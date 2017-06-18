package com.sapphire.org.service;

import com.sapphire.org.model.Items;
import com.sapphire.org.model.OrderDetails;

public interface OrderService {
	
	public OrderDetails prcoessBarCodeScan(Items items);

}
