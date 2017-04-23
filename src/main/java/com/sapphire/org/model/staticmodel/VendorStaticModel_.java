package com.sapphire.org.model.staticmodel;



import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.sapphire.org.model.Vendor;

@StaticMetamodel(Vendor.class)
public class VendorStaticModel_ {
  public static volatile SingularAttribute<Vendor, Integer> vid;
  public static volatile SingularAttribute<Vendor, String> vname;
  public static volatile SingularAttribute<Vendor, String> vaddress;
  public static volatile SingularAttribute<Vendor, String> vstate;
  public static volatile SingularAttribute<Vendor, String> vpostalCode; 
  public static volatile SingularAttribute<Vendor, String> vcomments; 
  public static volatile SingularAttribute<Vendor, String> vphone; 
}