package com.dassault.toggle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dassault.toggle.model.FamilyUser;
import com.dassault.toggle.model.Toggle;
import com.dassault.toggle.repository.FamilyRepo;
import com.dassault.toggle.repository.ToggleRepo;

@Service
public class ToggleService {

	@Autowired
	ToggleRepo toggleRepo;
	@Autowired
	FamilyRepo familyRepo;
	
	public Toggle updateToggle(Toggle toggle) {
		Toggle dbToggle = toggleRepo.findByIteam(toggle.getIteam());
		FamilyUser familyUser =  familyRepo.findByNameIgnoreCase(toggle.getUpdatedBy());
		
		if(dbToggle==null) {
			toggle.setComment(toggle.getIteam() +" is not correct iteam");
			
		}		
		
		else if(familyUser!=null){
			String existingStauts = dbToggle.getStatus();
			String status = toggle.getStatus();
			if(existingStauts.equalsIgnoreCase(status)) {
				toggle.setComment(toggle.getIteam() + " is alredy  "+toggle.getStatus());
			}else {
				toggle.setComment("updated the status");
				toggle.setStatus(toggle.getStatus());
				toggle.setId(dbToggle.getId());
				toggleRepo.save(toggle);
			}
		}
		else{
			toggle.setComment(toggle.getUpdatedBy() +" seems you are not family member");
		}
		return toggle;
	}
}
