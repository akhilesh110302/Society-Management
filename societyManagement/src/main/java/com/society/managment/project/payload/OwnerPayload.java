package com.society.managment.project.payload;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OwnerPayload {

	private Integer id;
	private Integer society_id;

	private String name;

	private String phoneNumber;
	
	private String adhar_no;
	
	private String email;
	
	private Boolean is_owner;
}
