package com.sapphire.org.service;

import java.util.List;

import com.sapphire.org.model.Vendor;


public interface VendorService {
	
	public Vendor saveVendor(Vendor vendor);
	public List<Vendor> getAllVendor();

}
