
package com.society.managment.project.entity;

import com.society.managment.project.utils.TableUtils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = TableUtils.TABLE_MST_SOCIETY_DETAIL)
public class SocietyDetail extends Auditable<Integer> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer society_id;

	@Column(name = "society_name")
	private String society_name;

	@Column(name = "address")
	private String address;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "pincode")
	private String pincode;

	@Column(name = "total_houses")
	private Integer total_houses;

}
