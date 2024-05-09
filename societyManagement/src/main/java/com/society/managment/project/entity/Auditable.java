package com.society.managment.project.entity;


import java.util.Date;

import static jakarta.persistence.TemporalType.TIMESTAMP;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.society.managment.project.utils.MyJsonDateSerializer;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Auditable<U> {

	@CreatedBy
	@Column(name = "created_by", updatable = false)
	protected U createdBy;

	@CreatedDate
	@Temporal(TIMESTAMP)
	@Column(name = "created_date", updatable = false)
	@JsonSerialize(using = MyJsonDateSerializer.class)
	protected Date createdDate;

	@LastModifiedBy
	@Column(name = "modified_by")
	protected U modifiedBy;

	@LastModifiedDate
	@Temporal(TIMESTAMP)
	@Column(name = "modified_date")
	@JsonSerialize(using = MyJsonDateSerializer.class)
	protected Date modifiedDate;
}
