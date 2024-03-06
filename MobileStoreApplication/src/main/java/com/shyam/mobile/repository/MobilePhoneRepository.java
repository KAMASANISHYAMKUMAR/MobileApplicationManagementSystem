package com.shyam.mobile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shyam.mobile.models.MobilePhone;

@Repository
public interface MobilePhoneRepository extends JpaRepository<MobilePhone, Long>{
	
	@Query("select m from MobilePhone m where m.brandName=:brandName")
	MobilePhone findByBrandName(@Param("brandName") String brandName);
//    List<MobilePhone> findByCostGreaterThan(double cost);
//    List<MobilePhone> findByProcessor(String processor);
//    List<MobilePhone> findByColorIn(List<String> colors);
//    List<String> findDistinctByModelName();
}
