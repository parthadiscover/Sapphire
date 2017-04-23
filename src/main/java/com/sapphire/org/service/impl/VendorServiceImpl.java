package com.sapphire.org.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sapphire.org.model.Vendor;
import com.sapphire.org.repository.QuerySpecification;
import com.sapphire.org.repository.VendorRepository;
import com.sapphire.org.service.VendorService;

@Service("vendorService")
@Transactional
public class VendorServiceImpl implements VendorService {
	
	@Autowired
	VendorRepository vendorRepository;

	@Override
	public Vendor saveVendor(Vendor vendor) {
		return vendorRepository.save(vendor);
	}

	@Override
	public List<Vendor> getAllVendor() {
		return vendorRepository.findAll();
	}

	@Override
	public List<Vendor> searchVendor(Vendor vendor) {
		// TODO Auto-generated method stub
		return vendorRepository.findAll(QuerySpecification.searchByVendorCriteria(vendor));
	}
	
	

}
