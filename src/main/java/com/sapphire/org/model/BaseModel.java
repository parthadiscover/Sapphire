package com.sapphire.org.model;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class BaseModel {
	
	public Property getStringProperty(String _strObj) {
		return new SimpleStringProperty(_strObj);
	}
	public Property getIntegerProperty(Integer _intObj) {
		return new SimpleIntegerProperty(_intObj);		
	}
	public Property getDoubleProperty(Double _dbObj) {
		return new SimpleDoubleProperty(_dbObj);		
	}

}
