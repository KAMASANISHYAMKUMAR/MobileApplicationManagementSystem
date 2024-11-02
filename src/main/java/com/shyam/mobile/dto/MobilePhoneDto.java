package com.shyam.mobile.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MobilePhoneDto {
	
	private Long id;
    private String brandName;
    private String modelName;
    private double cost;
    private String processor;
    private String color;

}
