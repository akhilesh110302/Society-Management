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

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/society")
@CrossOrigin
@RequiredArgsConstructor
public class SocietyController {

    private final SocietyRepository societyRepository;

    @Tag(name = "Society", description = "API for creating a new society")
    @PostMapping("/saveSociety")
    public ResponseEntity<?> saveSociety(@RequestBody SocietyDetail societyDetail) {
        societyRepository.save(societyDetail);
        return ResponseEntity.status(HttpStatus.OK).body("Society created successfully.");
    }

    @Tag(name = "Society", description = "API for retrieving all societies")
    @GetMapping("/getAllSociety")
    public ResponseEntity<?> getAllSociety() {
        List<SocietyDetail> c = societyRepository.findAll();
        if (c.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(c));
    }

    @Tag(name = "Society", description = "API for retrieving a society by ID using request parameter")
    @GetMapping("/getSocietyByIdReq")
    public ResponseEntity<?> getAllSocietyByIdUsingRequestParam(@RequestParam("societyId") Integer id) {
        try {
            societyRepository.findById(id).orElseThrow();
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Tag(name = "Society", description = "API for updating a society by ID")
    @PutMapping("/updateSociety/{id}")
    public ResponseEntity<?> updateSociety(@PathVariable Integer id, @RequestBody SocietyDetail updatedSociety) {
        try {
            SocietyDetail originalSociety = societyRepository.findById(id).orElseThrow();
            originalSociety.setAddress(updatedSociety.getAddress());
            originalSociety.setCity(updatedSociety.getCity());
            originalSociety.setPincode(updatedSociety.getPincode());
            originalSociety.setSociety_name(updatedSociety.getSociety_name());
            originalSociety.setState(updatedSociety.getState());
            originalSociety.setTotal_houses(updatedSociety.getTotal_houses());
            societyRepository.save(originalSociety);
            return ResponseEntity.ok().body(originalSociety);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
