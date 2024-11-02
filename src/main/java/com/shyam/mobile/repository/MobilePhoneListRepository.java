package com.shyam.mobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shyam.mobile.models.MobilePhoneList;

@Repository
public interface MobilePhoneListRepository extends JpaRepository<MobilePhoneList, Long>{

}
