package com.society.managment.project.entity;

import com.society.managment.project.utils.TableUtils;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = TableUtils.TABLE_MST_OWNER_DETAIL)
@RequiredArgsConstructor
public class VehicleDetail {
//	Table: VehicleDetail
//	--------------------------------
//	| Field Name       | Data Type  |
//	--------------------------------
//	| vehicle_id       | INT        |
//	| owner_id         | INT        | (Foreign key referencing OwnerDetail)
//	| make             | VARCHAR    |
//	| model            | VARCHAR    |
//	| year             | INT        |
//	| registration_no  | VARCHAR    |
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;


}
