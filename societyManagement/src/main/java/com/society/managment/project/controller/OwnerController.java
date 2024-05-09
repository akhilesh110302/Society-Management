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

import com.society.managment.project.entity.OwnerEntity;
import com.society.managment.project.repository.OwnerRepository;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/owner")
@CrossOrigin
@RequiredArgsConstructor
public class OwnerController {

	
	private final  OwnerRepository ownerRepository;
		
	@PostMapping("/saveOwner")
	public ResponseEntity<?> saveOwners(@RequestBody OwnerEntity ownerEntity) {

		ownerRepository.save(ownerEntity);
		return ResponseEntity.status(HttpStatus.OK).body("Owner created successfully.");
	}
	@Tag(name = "get", description = "GET methods of Owner APIs")
	@GetMapping("/getAllOwner")
	public ResponseEntity<?> getAllOwners() {

		List<OwnerEntity> c = ownerRepository.findAll();
		if(c.size()<=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(c));
	}

	@GetMapping("/getOwnerByIdPv/{customerId}")
	public  ResponseEntity<?> getAllOwnerByIdUsingPathVariable(@PathVariable("customerId") Integer id) {
		
		try {
			ownerRepository.findById(id).get();
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		catch(Exception e ){
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}

	@GetMapping("/getOwnerByIdReq")
	public ResponseEntity<?> getAllOwnerByIdUsingRequestParam(@RequestParam("customerId") Integer id) {
		try {
			ownerRepository.findById(id).get();
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		catch(Exception e ){
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}


	
	@PutMapping("/updateOwner/{id}")
	public ResponseEntity<?> updateOwners(@PathVariable Integer id,@RequestBody OwnerEntity updatedOwner) {
		
		try {
			OwnerEntity originalOwner = ownerRepository.findById(id).get();
			originalOwner.setEmail(updatedOwner.getEmail());
			originalOwner.setAdhar_no(updatedOwner.getAdhar_no());
			originalOwner.setIs_owner(updatedOwner.getIs_owner());
			originalOwner.setName(updatedOwner.getName());
			originalOwner.setPhoneNumber(updatedOwner.getPhoneNumber());
			originalOwner.setSociety_id(updatedOwner.getSociety_id());
			
			ownerRepository.save(originalOwner);
			 return ResponseEntity.ok().body(originalOwner);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
}
