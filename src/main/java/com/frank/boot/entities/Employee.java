package com.frank.boot.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee implements Serializable {
	
	private Integer id;
	private String lastName;
	private String email;
	private Integer gender; //性别 1男  0女
	private Integer dId;

}
