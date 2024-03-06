package com.shyam.mobile.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.shyam.mobile.dto.MobilePhoneDto;
import com.shyam.mobile.exceptions.MobileIdNotFoundException;
import com.shyam.mobile.exceptions.MobileNotFoundException;
import com.shyam.mobile.exceptions.MobilePhoneAlreadyExistsException;
import com.shyam.mobile.exceptions.MobilePhoneBrandNotExist;
import com.shyam.mobile.exceptions.MobilePhoneListNotExist;
import com.shyam.mobile.exceptions.MobilePhoneModelNotExist;
import com.shyam.mobile.exceptions.MobilesNotExistsException;
import com.shyam.mobile.models.MobilePhone;
import com.shyam.mobile.models.MobilePhoneList;
import com.shyam.mobile.repository.MobilePhoneListRepository;
import com.shyam.mobile.repository.MobilePhoneRepository;
import com.shyam.mobile.service.MobileService;

@Service
public class MobilephoneServiceImpl implements MobileService {
	
	@Autowired
	private MobilePhoneRepository mobilePhoneRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private MobilePhoneListRepository mobilePhoneListRepository;

	@Override
	public List<MobilePhone> getAllMobiles() throws MobilesNotExistsException {
		List<MobilePhone> mobilePhones = mobilePhoneRepository.findAll();
		if(!mobilePhones.isEmpty()) {
			return mobilePhones;
		}else {
			throw new MobilesNotExistsException();
		}
	}

	@Override
	public MobilePhone saveMobilePhone(MobilePhone mobilePhone) throws MobilePhoneAlreadyExistsException {
		if(mobilePhoneRepository.existsById(mobilePhone.getMobileId())) {
			throw new MobilePhoneAlreadyExistsException();
		}else {
			return mobilePhoneRepository.save(mobilePhone);
		}
	}

	@Override
	public MobilePhone getMobilePhoneById(long id) throws MobileIdNotFoundException {
		Optional<MobilePhone> mobilePhone = mobilePhoneRepository.findById(id);
		if(mobilePhone.isEmpty()) {
			throw new MobileIdNotFoundException();
		}else {
			
			return mobilePhone.get();
		}
	}

	@Override
	public MobilePhone getMobilePhoneByBrandName(String brandName) throws MobilePhoneBrandNotExist {
		MobilePhone mobilePhone = mobilePhoneRepository.findByBrandName(brandName);
		if(mobilePhone.getMobileName()==null) {
			throw new MobilePhoneBrandNotExist();
		}else {
			return mobilePhone;
		}
	}

	@Override
	public MobilePhone editMobilephone(MobilePhone mobilePhone) throws MobileIdNotFoundException {
		Optional<MobilePhone> dbMobilePhone = mobilePhoneRepository.findById(mobilePhone.getMobileId());
		if(dbMobilePhone.isPresent()){
			mobilePhone.setMobileId(mobilePhone.getMobileId());
			return mobilePhoneRepository.save(mobilePhone);
		}else {
			throw new MobileIdNotFoundException();
		}
	}

	@Override
	public String deleteMobilePhone(long id) throws MobileNotFoundException {
		Optional<MobilePhone> dbMobile = mobilePhoneRepository.findById(id);
		if(dbMobile.isPresent()) {
			mobilePhoneRepository.deleteById(id);
			return "MobilePhone Deleted Succesfully : "+id;  
		}else {
			throw new MobileNotFoundException();
		}
	}

	@Override
	public List<MobilePhoneDto> getAllMobilePhones() throws MobilesNotExistsException {
		List<MobilePhone> mobilePhone = mobilePhoneRepository.findAll();
		if(mobilePhone.isEmpty()){
			throw new MobilesNotExistsException();
		}else {
			return mobilePhone.stream().map(
					mobilePhone1 -> modelMapper.map(mobilePhone,MobilePhoneDto.class)
			).collect(Collectors.toList());
		}
	}

	@Override
	public MobilePhoneDto getMobilePhoneDtoById(long id) throws MobileIdNotFoundException {
		Optional<MobilePhone> mobilePhone = mobilePhoneRepository.findById(id);
		if(mobilePhone.isEmpty()){
			throw  new MobileIdNotFoundException();
		}else{
			return modelMapper.map(mobilePhone.get(),MobilePhoneDto.class);
		}
	}

	@Override
	public List<MobilePhoneDto> getMobilePhoneDtoByBrandName(String brandName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMobilePhoneCount(double cost) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<MobilePhone> getByProcessor(String processor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMobilePhonesCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MobilePhoneList addMobilePhoneToList(long mobilePhoneId, long mobilePhoneListId) throws MobilePhoneListNotExist, MobileIdNotFoundException{
		MobilePhone mobilePhone = mobilePhoneRepository.findById(mobilePhoneId)
				.orElseThrow(() -> new MobileIdNotFoundException());

		MobilePhoneList mobilePhoneList = mobilePhoneListRepository.findById(mobilePhoneListId)
				.orElseThrow(() -> new MobilePhoneListNotExist());

		mobilePhoneList.getMobilePhones().add(mobilePhone);
		return mobilePhoneListRepository.save(mobilePhoneList);
	}

	@Override
	public List<MobilePhone> getByColor(String color) {
		// TODO Auto-generated method stub
		return null;
	}

}
