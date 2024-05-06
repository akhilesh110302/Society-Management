package com.society.managment.project.entity;

import com.society.managment.project.utils.TableUtils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = TableUtils.TABLE_MST_OWNER)
public class OwnerEntity {

	@Id
	private Integer id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="middle_name")
	private String middleName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="phone_number")
	private String  phoneNumber;
}
