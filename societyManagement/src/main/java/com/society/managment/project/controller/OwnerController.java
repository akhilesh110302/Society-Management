package com.society.managment.project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.society.managment.project.payload.OwnerPayload;

import jakarta.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/owner")
@CrossOrigin
public class OwnerController {

//	private OwnerRepository ownerRepository;
	
	@PostMapping("/saveowner")
	public ResponseEntity<?> createOwner(HttpServletRequest httpServletRequest, @RequestBody OwnerPayload ownerPayload)
	{
		
		return null;
	}
}
