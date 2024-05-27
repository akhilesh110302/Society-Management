package com.society.managment.project.controller;

import java.util.ArrayList;
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
import com.society.managment.project.entity.SocietyDetail;
import com.society.managment.project.payload.OwnerPayload;
import com.society.managment.project.repository.OwnerRepository;
import com.society.managment.project.repository.SocietyRepository;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/owner")
@CrossOrigin
@RequiredArgsConstructor

public class OwnerController {

	private final OwnerRepository ownerRepository;
	private final SocietyRepository societyRepository;

	@Tag(name = "Owners", description = "API for creating a new owner")
	@PostMapping("/saveOwner")
	public ResponseEntity<?> saveOwners(@RequestBody OwnerPayload entity) {

		Optional<SocietyDetail> optional = societyRepository.findById(entity.getSociety_id());
		if (optional.isPresent()) {
			OwnerEntity ownerEntity =new OwnerEntity();
	        ownerEntity.setAdharNo(entity.getAdhar_no());
	        ownerEntity.setEmail(entity.getEmail());
	        ownerEntity.setIsOwner(entity.getIs_owner());
	        ownerEntity.setName(entity.getName());
	        ownerEntity.setPhoneNumber(entity.getPhoneNumber());
	        ownerEntity.setSociety_id(optional.get());
			ownerRepository.save(ownerEntity);
			return ResponseEntity.status(HttpStatus.OK).body("Owner created successfully.");
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Society not found.");
		}
	}

	@Tag(name = "Owners", description = "API for retrieving all owners")
	@GetMapping("/getAllOwner")
	public ResponseEntity<?> getAllOwners() {
		List<OwnerEntity> entities = ownerRepository.findAll();
		if (entities.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		List<OwnerPayload> list = new ArrayList<>();
		for (OwnerEntity entity : entities) {
			OwnerPayload ownerPayload = OwnerPayload.builder().id(entity.getId()).adhar_no(entity.getAdharNo())
					.email(entity.getEmail()).is_owner(entity.getIsOwner()).name(entity.getName())
					.phoneNumber(entity.getPhoneNumber()).society_id(entity.getSociety_id().getId()).build();
			list.add(ownerPayload);

		}
		return ResponseEntity.ok(list);

	}

	@Tag(name = "Owners", description = "API for retrieving an owner by ID using path variable")
	@GetMapping("/getOwnerByIdPv/{customerId}")
	public ResponseEntity<?> getAllOwnerByIdUsingPathVariable(@PathVariable("customerId") Integer id) {

		Optional<OwnerEntity> OptionalEntity = ownerRepository.findById(id);

		if (OptionalEntity.isPresent()) {
			OwnerEntity entity = OptionalEntity.get();
			OwnerPayload ownerPayload = OwnerPayload.builder().id(entity.getId()).adhar_no(entity.getAdharNo())
					.email(entity.getEmail()).is_owner(entity.getIsOwner()).name(entity.getName())
					.phoneNumber(entity.getPhoneNumber()).society_id(entity.getSociety_id().getId()).build();
			return ResponseEntity.status(HttpStatus.OK).body(ownerPayload);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@Tag(name = "Owners", description = "API for retrieving an owner by ID using request parameter")
	@GetMapping("/getOwnerByIdReq")
	public ResponseEntity<?> getAllOwnerByIdUsingRequestParam(@RequestParam("customerId") Integer id) {

		Optional<OwnerEntity> OptionalEntity = ownerRepository.findById(id);

		if (OptionalEntity.isPresent()) {
			OwnerEntity entity = OptionalEntity.get();
			OwnerPayload ownerPayload = OwnerPayload.builder().id(entity.getId()).adhar_no(entity.getAdharNo())
					.email(entity.getEmail()).is_owner(entity.getIsOwner()).name(entity.getName())
					.phoneNumber(entity.getPhoneNumber()).society_id(entity.getSociety_id().getId()).build();
			return ResponseEntity.status(HttpStatus.OK).body(ownerPayload);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@Tag(name = "Owners", description = "API for updating an owner by ID")
	@PutMapping("/updateOwner/{id}")
	public ResponseEntity<?> updateOwners(@PathVariable Integer id, @RequestBody OwnerEntity updatedOwner) {
		try {
			OwnerEntity originalOwner = ownerRepository.findById(id).orElseThrow();
			originalOwner.setEmail(updatedOwner.getEmail());
			originalOwner.setAdharNo(updatedOwner.getAdharNo());
			originalOwner.setIsOwner(updatedOwner.getIsOwner());
			originalOwner.setName(updatedOwner.getName());
			originalOwner.setPhoneNumber(updatedOwner.getPhoneNumber());
			originalOwner.setSociety_id(updatedOwner.getSociety_id());

			ownerRepository.save(originalOwner);
			return ResponseEntity.ok().body(originalOwner);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
