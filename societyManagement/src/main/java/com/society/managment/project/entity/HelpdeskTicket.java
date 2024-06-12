package com.society.managment.project.entity;

import com.society.managment.project.utils.TableUtils;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@Entity
@Table(name = TableUtils.TABLE_MST_OWNER_DETAIL)
@RequiredArgsConstructor
public class HelpdeskTicket {

}
