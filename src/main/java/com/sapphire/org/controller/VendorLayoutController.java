package com.sapphire.org.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sapphire.org.config.ViewFactory;
import com.sapphire.org.constant.ViewPath;
import com.sapphire.org.model.Vendor;
import com.sapphire.org.service.VendorService;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

//import com.fx.mediator.Mediator;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

@Controller
public class VendorLayoutController  extends AbstractController{


	@Autowired
	private VendorDetailsController vendorDetailsController;
	
	@Autowired
	public ViewFactory viewFactory;
	
	@Autowired
	public VendorService vendorService;
	
	private  AnchorPane vendorLayout;
	
	@FXML
	private TableView<Vendor>  _vendorListTable;
	
    @FXML
    private TableColumn<Vendor, String> _vendorTableColumn;
    
    private ObservableList<Vendor> vendorData ;

	public VendorLayoutController() {
	}

	@FXML
	private void initialize() {

		_vendorTableColumn.setCellValueFactory(cellData -> cellData.getValue().getProperty(cellData.getValue().getVname()));
		 vendorLayout = (AnchorPane)getParentNode();
		 this.addVendorDetailsDisplayView();
		 this.displayVendorList();
	}

	/**
	 * Called when the user clicks the new button. Opens a dialog to edit
	 * details for a new vendor.
	 */

	@FXML
	private void handleNewVendor() {

		System.out.println("Test event" );
		Node vendorDetailsView = vendorDetailsController.getVendorDetailsEditView();		
		

	}

	
	public void displayVendorList(){
		
		
		List<Vendor> vendorList = vendorService.getAllVendor();
		System.out.println(vendorList.size());
		vendorData = FXCollections.observableArrayList(vendorList);
		_vendorListTable.setItems(vendorData);

		
	}
    
	private void addVendorDetailsDisplayView(){
		try {
			Node vendorDetailsView = vendorDetailsController.loadView();
			vendorDetailsController.getVendorDetailsDisplayView();		
			ObservableList<Node> anchorList =  vendorLayout.getChildren();
			BorderPane boderPane = (BorderPane)(anchorList.get(0));
			VBox centreVbox = (VBox)boderPane.getCenter();		
			centreVbox.getChildren().add(vendorDetailsView);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Node  loadView() throws IOException {
		return viewFactory.load(ViewPath.VIEW_LAYOUT);
	}
	
	
	

}
