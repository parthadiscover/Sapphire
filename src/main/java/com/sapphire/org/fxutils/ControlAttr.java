package com.sapphire.org.fxutils;

import java.util.function.Function;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControlAttr {
	
	private String displayName;
	private Double width;
	private Double height;

	
	public ControlAttr(){
		
	}
	public ControlAttr(String displayName,Double width,Double height){ 
		this.displayName = displayName;
		this.width = width;
		this.height = height;
	}

	public Double getWidth() {
		return width;
	}
	public void setWidth(Double width) {
		this.width = width;
	}
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	
	
}
