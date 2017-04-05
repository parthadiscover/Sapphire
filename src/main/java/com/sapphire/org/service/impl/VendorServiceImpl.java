package com.sapphire.org.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sapphire.org.model.Vendor;
import com.sapphire.org.repository.VendorRepository;
import com.sapphire.org.service.VendorService;

@Service("vendorService")
@Transactional
public class VendorServiceImpl implements VendorService {
	
	@Autowired
	VendorRepository vendorRepository;

	@Override
	public void saveVendor(Vendor vendor) {

		vendorRepository.save(vendor);
		
	}
	
	

}
