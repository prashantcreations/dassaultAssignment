package com.dassault.toggle.repository;

import org.springframework.data.repository.CrudRepository;

import com.dassault.toggle.model.FamilyUser;

public interface FamilyRepo extends CrudRepository<FamilyUser, Integer>{
	
	FamilyUser findByNameIgnoreCase(String name);

}
