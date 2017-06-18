package com.sapphire.org.model.staticmodel;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.sapphire.org.model.Items;
import com.sapphire.org.model.Vendor;

@StaticMetamodel(Items.class)
public class ItemsStaticModel_ {

	  public static volatile SingularAttribute<Vendor, Integer> itemId;
	  public static volatile SingularAttribute<Vendor, String> itemBrcd;
	  public static volatile SingularAttribute<Vendor, String> itemDesc;
	  public static volatile SingularAttribute<Vendor, String> itemType;
	  public static volatile SingularAttribute<Vendor, Double> itenVat; 
	  public static volatile SingularAttribute<Vendor, String> isDeleted; 
	
}
