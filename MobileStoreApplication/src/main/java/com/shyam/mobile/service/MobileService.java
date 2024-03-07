package com.shyam.mobile.service;

import java.util.List;

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

public interface MobileService {
	
	List<MobilePhone> getAllMobiles() throws MobilesNotExistsException;
    MobilePhone saveMobilePhone(MobilePhone mobilePhone) throws MobilePhoneAlreadyExistsException;
    MobilePhone getMobilePhoneById(long id) throws MobileIdNotFoundException;
    MobilePhone getMobilePhoneByBrandName(String brandName) throws MobilePhoneBrandNotExist;
    MobilePhone editMobilephone(MobilePhone mobilePhone) throws MobileIdNotFoundException;
    String deleteMobilePhone(long id) throws MobileNotFoundException;
    List<MobilePhoneDto> getAllMobilePhones() throws MobilesNotExistsException;
    MobilePhoneDto getMobilePhoneDtoById(long id) throws MobileIdNotFoundException;
    List<MobilePhoneDto> getMobilePhoneDtoByBrandName(String brandName) throws MobilePhoneBrandNotExist;
    int getMobilePhoneCount(double cost);
    List<MobilePhone> getByProcessor(String processor) throws MobilePhoneProcessorNotFoundException;
    List<MobilePhone> getByColor(String color) throws MobileColorNotFoundException;
    int getMobilePhonesCount() throws MobilesNotExistsException;
    MobilePhoneList addMobilePhoneToList(long mobilePhoneId, long mobilePhoneListId) throws MobileIdNotFoundException, MobilePhoneListNotExist;
    
}
