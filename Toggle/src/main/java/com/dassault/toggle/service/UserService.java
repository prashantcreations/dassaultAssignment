package com.dassault.toggle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dassault.toggle.model.FamilyUser;
import com.dassault.toggle.model.Toggle;
import com.dassault.toggle.repository.FamilyRepo;
import com.dassault.toggle.repository.ToggleRepo;

@Service
public class UserService {

	@Autowired
	FamilyRepo familyRepo;
	

	public FamilyUser createUser(FamilyUser user) {
		
		FamilyUser userData= familyRepo.save(user);
		return userData;
	}
}
