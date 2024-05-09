package com.society.managment.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.society.managment.project.entity.SocietyDetail;
import com.society.managment.project.repository.SocietyRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/society")
@CrossOrigin
@RequiredArgsConstructor
public class SocietyController {
	
	private final  SocietyRepository societyRepository;
	
	@PostMapping("/saveSociety")
	public ResponseEntity<?> saveSociety(@RequestBody SocietyDetail societyDetail) {

		societyRepository.save(societyDetail);
		return ResponseEntity.status(HttpStatus.OK).body("Society created successfully.");

	}

	@GetMapping("/getAllSociety")
	public ResponseEntity<?> getAllSociety() {

		List<SocietyDetail> c = societyRepository.findAll();
		if(c.size()<=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(c));
	}

	@GetMapping("/getSocietyByIdReq")
	public ResponseEntity<?> getAllSocietyByIdUsingRequestParam(@RequestParam("societyId") Integer id) {
		try {
			societyRepository.findById(id).get();
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		catch(Exception e ){
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}


	
	@PutMapping("/updateSociety/{id}")
	public ResponseEntity<?> updateOwners(@PathVariable Integer id,@RequestBody SocietyDetail updateSociety) {
		
		try {
			SocietyDetail originalSociety = societyRepository.findById(id).get();
			originalSociety.setAddress(updateSociety.getAddress());
			originalSociety.setCity(updateSociety.getCity());
			originalSociety.setPincode(updateSociety.getPincode());
			originalSociety.setSociety_name(updateSociety.getSociety_name());
			originalSociety.setState(updateSociety.getState());
			originalSociety.setTotal_houses(updateSociety.getTotal_houses());
			societyRepository.save(originalSociety);
			 return ResponseEntity.ok().body(originalSociety);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
}
