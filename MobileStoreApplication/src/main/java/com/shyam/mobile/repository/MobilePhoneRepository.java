package com.shyam.mobile.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shyam.mobile.models.MobilePhone;

@Repository
public interface MobilePhoneRepository extends JpaRepository<MobilePhone, Long>{
	
	@Query("select m from MobilePhone m where m.brandName=:brandName")
	Optional<MobilePhone> findByBrandName(@Param("brandName") String brandName);
//    List<MobilePhone> findByCostGreaterThan(double cost);
    
    @Query("select m from MobilePhone m where m.processor = :processor")
    List<MobilePhone> findByProcessor(@Param("processor") String processor);
    
    @Query("select m from MobilePhone m where m.color = :color")
    List<MobilePhone> findByColor(String color);
}
