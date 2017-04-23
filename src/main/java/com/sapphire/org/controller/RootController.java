package com.sapphire.org.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sapphire.org.config.ViewFactory;
import com.sapphire.org.constant.ViewPath;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


@Controller
public class RootController extends AbstractController{

	@Autowired
	private ViewFactory viewFactory;
	
	
	@Autowired
	private VendorLayoutController vendorLayoutController;
	
	private BorderPane borderPane ;
	
	
	
	public RootController(){		
	}
	
	@FXML
	private void initialize() {

		borderPane = (BorderPane) getParentNode();
		completeLayout();
		
		
	}
	
	
	 private void setVendorLayout() {
		 
		 AnchorPane vendorLayout = null;
		try {
			vendorLayout = (AnchorPane) vendorLayoutController.loadView();
			borderPane.setCenter(vendorLayout);
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
	 }

	@Override
	public Node loadView() throws IOException {
		return viewFactory.load(ViewPath.ROOT_LAYOUT);
	}

	@Override
	protected void completeLayout() {
		// TODO Auto-generated method stub
		setVendorLayout();
	}
	

}
