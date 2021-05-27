package com.dassault.toggle.repository;



import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dassault.toggle.model.Toggle;

@Repository
public interface ToggleRepo extends CrudRepository<Toggle,Integer>{

	
	 Toggle findByIteam(String iteamName);

}
