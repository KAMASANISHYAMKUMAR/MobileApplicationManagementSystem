package com.shyam.mobile.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class MobilePhone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long mobileId;
	private String brandName;
	private String mobileName;
	private String color;
	private String batteryPower;
	private String processor;
	private double mobilePhoneCost;
	
	
}
