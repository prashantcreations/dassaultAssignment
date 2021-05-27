package com.dassault.toggle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dassault.toggle.model.Toggle;
import com.dassault.toggle.service.ToggleService;

@RestController
@RequestMapping("/toggle")
public class ToggleController {
	
	@Autowired
	ToggleService toggleService;
	
	
	
	@PutMapping("/updateToggle")
	public ResponseEntity<Toggle> updateToggle(@RequestBody Toggle toggle){
		
		Toggle toggleStatus = toggleService.updateToggle(toggle);
		return new ResponseEntity<Toggle>(toggleStatus,HttpStatus.OK);
	}

}
