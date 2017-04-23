package com.sapphire.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.sapphire.org.model.Vendor;


@Repository
public interface VendorRepository extends JpaRepository<Vendor,Long> , JpaSpecificationExecutor<Vendor> {


	
}
