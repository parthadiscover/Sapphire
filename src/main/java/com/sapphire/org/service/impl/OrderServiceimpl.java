package com.sapphire.org.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sapphire.org.model.Items;
import com.sapphire.org.model.OrderDetails;
import com.sapphire.org.model.Vendor;
import com.sapphire.org.repository.ItemRepository;
import com.sapphire.org.repository.QuerySpecification;
import com.sapphire.org.service.OrderService;
import com.sapphire.org.utils.RulesUtils;



@Service("orderService")
@Transactional
public class OrderServiceimpl implements OrderService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	

	public OrderDetails prcoessBarCodeScan(Items items) {
		
		items = itemRepository.findOne(QuerySpecification.searchByItemsProductCodeCriteria(items));
		
		if(items == null){
			throw new RuntimeException("Barcode not Found");
		}
		
		OrderDetails orderDetails = new OrderDetails(items);
		return populateOrderDetailsFromItems(orderDetails);
	}
	
	
	
	private OrderDetails populateOrderDetailsFromItems(OrderDetails orderDetails){
		Items item = orderDetails.getItem();
		Double unitSellPrc = item.getItemRate();		
		Double netPrice = orderDetails.getOrderItemQty() == null ? unitSellPrc : unitSellPrc * orderDetails.getOrderItemQty();
		Double vatAmt = RulesUtils.calculateVAT(netPrice, item.getItemVat());		 
		Double grossAmt = netPrice + vatAmt;
		
		orderDetails.setOrderItemQty(orderDetails.getOrderItemQty() == null ? 1 : orderDetails.getOrderItemQty());
		orderDetails.setOrderItemSellPrc(unitSellPrc);
		orderDetails.setOrderItemNetPrc(netPrice);
		orderDetails.setOrderItemVatAmt(vatAmt);
		orderDetails.setOrderItemGrossPrc(grossAmt);
		return orderDetails;
		
	}
	

}
