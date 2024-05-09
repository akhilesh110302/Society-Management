package com.society.managment.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.society.managment.project.entity.OwnerEntity;


public interface OwnerRepository extends JpaRepository<OwnerEntity, Integer> {

}
