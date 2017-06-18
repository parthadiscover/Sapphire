package com.sapphire.org.fxutils;

import org.controlsfx.glyphfont.FontAwesome;
import org.controlsfx.glyphfont.GlyphFont;
import org.controlsfx.glyphfont.GlyphFontRegistry;

import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Control;

public class BasicFxUtils {
	
	
	static {
        // Register a custom default font
        GlyphFontRegistry.register("icomoon", BasicFxUtils.class.getResourceAsStream("icomoon.ttf") , 16);
    }
	
	private static GlyphFont fontAwesome = GlyphFontRegistry.font("FontAwesome");
	
	public static Control getSaveButton(ControlAttr _cattr){
		
		 Button saveButton = new Button("",fontAwesome.create(FontAwesome.Glyph.SAVE));
		 saveButton.setContentDisplay(ContentDisplay.TOP);	
		 
		 if(_cattr == null){
			 saveButton.setMaxWidth(Double.MAX_VALUE);			 
		 }else{
			 saveButton.setText(_cattr.getDisplayName());
			 saveButton.setMaxWidth(_cattr.getWidth());
			 saveButton.setMaxHeight(_cattr.getHeight());
			 
			 
			 saveButton.setPrefWidth(_cattr.getWidth());
			 saveButton.setPrefHeight(_cattr.getHeight());
			 

			 
		 }
		 return saveButton;
	}
	
	
	public static Control getSearchButton(ControlAttr _cattr){
		
		 Button searchButton = new Button("",fontAwesome.create(FontAwesome.Glyph.SEARCH));
		 searchButton.setContentDisplay(ContentDisplay.TOP);	
		 
		 if(_cattr == null){
			 searchButton.setMaxWidth(Double.MAX_VALUE);			 
		 }else{
			 searchButton.setText(_cattr.getDisplayName());
			 searchButton.setMaxWidth(_cattr.getWidth());
			 searchButton.setMaxHeight(_cattr.getHeight());
			 
			 searchButton.setPrefWidth(_cattr.getWidth());
			 searchButton.setPrefHeight(_cattr.getHeight());

		 }
		 return searchButton;
	}
	
	
	public static Control getAddButton(ControlAttr _cattr){
		
		 Button searchButton = new Button("",fontAwesome.create(FontAwesome.Glyph.PLUS_SQUARE));
		 searchButton.setContentDisplay(ContentDisplay.TOP);	
		 
		 if(_cattr == null){
			 searchButton.setMaxWidth(Double.MAX_VALUE);			 
		 }else{
			 searchButton.setText(_cattr.getDisplayName());
			 searchButton.setMaxWidth(_cattr.getWidth());
			 searchButton.setMaxHeight(_cattr.getHeight());
			 
			 searchButton.setPrefWidth(_cattr.getWidth());
			 searchButton.setPrefHeight(_cattr.getHeight());

		 }
		 return searchButton;
	}
	

}
