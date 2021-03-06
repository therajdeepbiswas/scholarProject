package com.sap.scholarProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sap.scholarProject.model.Scholar;
import com.sap.scholarProject.service.ScholarService;

// Define APIs

@RestController
@RequestMapping("api/v1")
public class ScholarController {
	
	private ScholarService scholarService;
	
	@Autowired
	public ScholarController(ScholarService scholarService) {
		this.scholarService = scholarService;
	}
	
	@GetMapping("scholars")
	public List<Scholar> getAllScholars() {
		return scholarService.getAllScholars();  
	}
	
	@GetMapping("scholar")
	public Scholar getScholar(@RequestParam String id) {
		return scholarService.getScholar(id); 
	}
	
	@PostMapping("scholar")
	public void addScholar(@RequestBody Scholar scholar) {
		System.out.println(scholar.getName());
		scholarService.addScholar(scholar);
	}
	
	@DeleteMapping("scholar")
	public void deleteScholar(@RequestParam String id) {
		scholarService.deleteScholar(id);
		return;
	}
}