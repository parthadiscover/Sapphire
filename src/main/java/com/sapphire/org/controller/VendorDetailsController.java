package com.sapphire.org.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.sapphire.org.config.ViewFactory;
import com.sapphire.org.constant.ViewPath;
import com.sapphire.org.model.Vendor;
import com.sapphire.org.service.VendorService;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

@Controller
public class VendorDetailsController extends AbstractController {

	@Autowired
	private ViewFactory viewFactory;
	
	@Autowired
	private VendorService vendorService;
	
	@Autowired
	private VendorLayoutController vendorLayoutController; 

	@FXML
	private Label _vendorDetHeaderLabel;

	@FXML
	private GridPane _vendorDetTable;

	@FXML
	private TextField _vendorName;

	@FXML
	private TextField _vendorAddress;

	@FXML
	private TextField _vendorState;

	@FXML
	private TextField _vendorCity;

	@FXML
	private TextField _vendorPin;

	@FXML
	private TextField _vendorPhone;

	@FXML
	private TextArea _vendorComments;

	@FXML
	private Label _vendorNameLabel;

	@FXML
	private Label _vendorAddressLabel;

	@FXML
	private Label _vendorStateLabel;

	@FXML
	private Label _vendorCityLabel;

	@FXML
	private Label _vendorPinLabel;

	@FXML
	private Label _vendorPhoneLabel;
	
	@FXML
	private Label _vendorCommentLabel;

	private AnchorPane vendorDetails;

	public VendorDetailsController() {
	}

	@FXML
	private void initialize() {
		vendorDetails = (AnchorPane) getParentNode();
	}

	public Node getVendorDetailsDisplayView(Vendor vendor) {

		_vendorName.setVisible(false);
		_vendorAddress.setVisible(false);
		_vendorState.setVisible(false);
		_vendorCity.setVisible(false);
		_vendorPin.setVisible(false);
		_vendorPhone.setVisible(false);
		_vendorComments.setVisible(false);
		
		
		
		_vendorNameLabel.setVisible(true);
		_vendorAddressLabel.setVisible(true);
		_vendorStateLabel.setVisible(true);
		_vendorCityLabel.setVisible(true);
		_vendorPinLabel.setVisible(true);
		_vendorPhoneLabel.setVisible(true);
		_vendorCommentLabel.setVisible(true);
		
		_vendorNameLabel.setText(vendor.getVname());
		_vendorAddressLabel.setText(vendor.getVaddress());
		_vendorStateLabel.setText(vendor.getVstate());
		_vendorCityLabel.setText(vendor.getVcity());
		_vendorPinLabel.setText(vendor.getVpostalCode());
		_vendorPhoneLabel.setText(vendor.getVphone());
		_vendorCommentLabel.setText(vendor.getVcomments());
		
		
		//Set Vendor Label
		_vendorDetHeaderLabel.setText("Vendor Details ....");

		return vendorDetails;
	}
	
	@FXML
	public Node getVendorDetailsEditView() {

		_vendorName.setVisible(true);
		_vendorAddress.setVisible(true);
		_vendorState.setVisible(true);
		_vendorCity.setVisible(true);
		_vendorPin.setVisible(true);
		_vendorPhone.setVisible(true);
		_vendorComments.setVisible(true);

		_vendorNameLabel.setVisible(false);
		_vendorAddressLabel.setVisible(false);
		_vendorStateLabel.setVisible(false);
		_vendorCityLabel.setVisible(false);
		_vendorPinLabel.setVisible(false);
		_vendorPhoneLabel.setVisible(false);
		_vendorCommentLabel.setVisible(false);
		
		//Set Vendor Label
		_vendorDetHeaderLabel.setText("Add New Vendors.......");
		return vendorDetails;
	}
	
	
	@FXML
	public void saveVendorDetails(){
		
		System.out.println("Called Vendor Save");
		
		Vendor _vendor = new Vendor(_vendorName.getText(),
									_vendorAddress.getText(),
									_vendorState.getText(),									
									_vendorPin.getText(),
									_vendorCity.getText(),
									_vendorPhone.getText(),
									_vendorComments.getText()				
								  );
		Vendor _savedVendor = vendorService.saveVendor(_vendor);
		vendorLayoutController.displayVendorList();
		this.getVendorDetailsDisplayView(_savedVendor);
		
	}

	@Override
	public Node loadView() throws IOException {
		return viewFactory.load(ViewPath.VIEW_DETAILS);
	}

}
