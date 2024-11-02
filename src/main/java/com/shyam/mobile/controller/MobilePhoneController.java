package com.shyam.mobile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shyam.mobile.dto.MobilePhoneDto;
import com.shyam.mobile.exceptions.MobileColorNotFoundException;
import com.shyam.mobile.exceptions.MobileIdNotFoundException;
import com.shyam.mobile.exceptions.MobileNotFoundException;
import com.shyam.mobile.exceptions.MobilePhoneAlreadyExistsException;
import com.shyam.mobile.exceptions.MobilePhoneBrandNotExist;
import com.shyam.mobile.exceptions.MobilePhoneListNotExist;
import com.shyam.mobile.exceptions.MobilePhoneProcessorNotFoundException;
import com.shyam.mobile.exceptions.MobilesNotExistsException;
import com.shyam.mobile.models.MobilePhone;
import com.shyam.mobile.models.MobilePhoneList;
import com.shyam.mobile.service.MobileService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/mobile")
public class MobilePhoneController {
	
	@Autowired
	private MobileService mobileService;
	
	@PostMapping("/save")
	public ResponseEntity<MobilePhone> post(MobilePhone mobilePhone) throws MobilePhoneAlreadyExistsException{
		return new ResponseEntity<MobilePhone>(mobileService.saveMobilePhone(mobilePhone),HttpStatus.OK);
	}
	@PutMapping("/updateMobile")
	public ResponseEntity<MobilePhone> put(@RequestBody MobilePhone mobilePhone) throws MobileIdNotFoundException{
		return new ResponseEntity<>(mobileService.editMobilephone(mobilePhone),HttpStatus.OK);
	}
	@GetMapping("/getAllMobiles")
	public ResponseEntity<List<MobilePhone>> getAllMobiles() throws MobilesNotExistsException{
		return new ResponseEntity<>(mobileService.getAllMobiles(),HttpStatus.OK);
	}
	@GetMapping("/getMobileById")
	public ResponseEntity<MobilePhone> get(@RequestParam long id) throws MobileIdNotFoundException{
		return new ResponseEntity<>(mobileService.getMobilePhoneById(id),HttpStatus.OK);
	}
	@DeleteMapping("/deleteMobile")
	public ResponseEntity<String> delete(@RequestParam long id) throws MobileNotFoundException{
		return new ResponseEntity<>(mobileService.deleteMobilePhone(id),HttpStatus.OK);
	}

	@GetMapping("/mobilesByBrandName")
	public ResponseEntity<MobilePhone> getByBrand(@RequestParam String brandName) throws MobilePhoneBrandNotExist {
		return new ResponseEntity<>(mobileService.getMobilePhoneByBrandName(brandName),HttpStatus.OK);
	}
	@GetMapping("/getAllMobilesByDto")
	public ResponseEntity<List<MobilePhoneDto>> get() throws MobilesNotExistsException {
		return new ResponseEntity<>(mobileService.getAllMobilePhones(),HttpStatus.OK);
	}

	@GetMapping("/getMobilesDtoById")
	public ResponseEntity<MobilePhoneDto> getDtoById(@RequestParam long id) throws MobileIdNotFoundException {
		return new ResponseEntity<>(mobileService.getMobilePhoneDtoById(id),HttpStatus.OK);
	}
	
	@GetMapping("/getCost")
	public ResponseEntity<Integer> get(@RequestParam double cost)throws MobilesNotExistsException{
		return new ResponseEntity<>(mobileService.getMobilePhoneCount(cost),HttpStatus.OK);
	} //get total number of mobile phones who having cost > 10K

	@GetMapping("/getProcessor")
	public ResponseEntity<List<MobilePhone>> getProcessor(@RequestParam String processor)throws MobilePhoneProcessorNotFoundException{
		return new ResponseEntity<>(mobileService.getByProcessor(processor),HttpStatus.OK);
	}
	//get Mobile Phone whose having processor with name - Quad Core

	@GetMapping("/getColor")
	public ResponseEntity<List<MobilePhone>> getColor(@RequestParam String color) throws MobileColorNotFoundException{
		return new ResponseEntity<>(mobileService.getByColor(color),HttpStatus.OK);
	} //get Mobile Phone whose having color - black and blue

	@GetMapping("/getCountMobiles")
	public ResponseEntity<Integer> getAll()throws MobilesNotExistsException{
		return new ResponseEntity<>(mobileService.getMobilePhonesCount(),HttpStatus.OK);
	} //get total number of mobile phone who are having unique model names

	@PostMapping("/add")
	public ResponseEntity<MobilePhoneList> post(@RequestParam long mobilePhoneId,@RequestParam long MobilePhoneListId) throws MobilePhoneListNotExist, MobileIdNotFoundException {
		return new ResponseEntity<>(mobileService.addMobilePhoneToList(mobilePhoneId,MobilePhoneListId),HttpStatus.OK);
	} //adding mobilePhone to MobilePhoneList
}
