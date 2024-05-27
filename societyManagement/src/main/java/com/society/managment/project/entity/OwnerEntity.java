package com.society.managment.project.entity;

import com.society.managment.project.utils.TableUtils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = TableUtils.TABLE_MST_OWNER_DETAIL)
@RequiredArgsConstructor
public class OwnerEntity extends Auditable<Integer>  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "society_id_fn_key"), name = "society_id" )
	private SocietyDetail society_id;

	@Column(name = "name")
	private String name;

	@Column(name = "phone_no")
	private String phoneNumber;
	
	@Column(name = "adharNo")
	private String adharNo;
	
	@Column(name = "email")
	private String email;

	@Column(name = "is_owner")
	private Boolean isOwner;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "vehicle_id_fn_key"), name = "vehicle_id" )
	private VehicleDetail vehicleId;
	

	

}
