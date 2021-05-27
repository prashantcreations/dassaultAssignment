package com.dassault.toggle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dassault.toggle.model.FamilyUser;
import com.dassault.toggle.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;	
	
	@PostMapping("/createUser")
	public ResponseEntity<FamilyUser> createUser(@RequestBody FamilyUser user){
		
		FamilyUser userData = userService.createUser(user);
		return new ResponseEntity<FamilyUser>(userData,HttpStatus.OK);
	}

}
