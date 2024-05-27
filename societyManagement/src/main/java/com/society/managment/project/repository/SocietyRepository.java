package com.society.managment.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.society.managment.project.entity.SocietyDetail;


public interface SocietyRepository extends JpaRepository<SocietyDetail, Integer> {
}
