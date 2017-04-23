package com.sapphire.org.controller;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sapphire.org.config.ViewFactory;
import com.sapphire.org.constant.ViewPath;
import com.sapphire.org.fxutils.BasicFxUtils;
import com.sapphire.org.fxutils.ControlAttr;
import com.sapphire.org.model.Vendor;
import com.sapphire.org.service.VendorService;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

//import com.fx.mediator.Mediator;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
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
    
    @FXML
    private ToolBar _vendorSearchToolbar;
    
    @FXML
    private ToolBar _vendorLayoutToolBar;

    @FXML
    private TextField _vendorSearchText;
    
    private ObservableList<Vendor> vendorData ;

	public VendorLayoutController() {
	}

	@FXML
	private void initialize() {

		_vendorTableColumn.setCellValueFactory(cellData -> cellData.getValue().getProperty(cellData.getValue().getVname()));
		 vendorLayout = (AnchorPane)getParentNode();	
		 this.completeLayout();
		 this.displayVendorList();
		 this.addVendorDetailsDisplayView();
		 // Addind Vendor Selection Listner
 		 _vendorListTable.getSelectionModel().selectedItemProperty().addListener(
	                (observable, oldValue, newValue) ->  {  if (newValue!=null) vendorDetailsController.getVendorDetailsDisplayView(newValue) ;});
		 
		 
	}

	

	
	public void displayVendorList(){
		
		
		List<Vendor> vendorList = vendorService.getAllVendor();
		vendorData = FXCollections.observableArrayList(vendorList);
		_vendorListTable.setItems(vendorData);

		
	}
    
	private void addVendorDetailsDisplayView(){
		try {
			Node vendorDetailsView = vendorDetailsController.loadView();
			//Setting the first elemnet in the Table list while first time populating
			Vendor _firstItem = _vendorListTable.getItems().size() > 0 ? _vendorListTable.getItems().get(0) : null;	
			if(_firstItem == null){
				vendorDetailsController.getVendorDetailsEditView();
			}else{
				vendorDetailsController.getVendorDetailsDisplayView(_firstItem);	
			}			
			
			ObservableList<Node> anchorList =  vendorLayout.getChildren();
			BorderPane boderPane = (BorderPane)(anchorList.get(0));
			VBox centreVbox = (VBox)boderPane.getCenter();		
			centreVbox.getChildren().add(vendorDetailsView);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	protected void completeLayout(){
		
		//  Add Search Button
		Button _searchBtn = (Button) BasicFxUtils.getSearchButton(new ControlAttr("",10d,5d));
		_searchBtn.setOnAction(this::searchVendor);
		_vendorSearchToolbar.getItems().add(_searchBtn);
		
	//  Add New Vendor  Button
		Button _addNewBtn = (Button) BasicFxUtils.getAddButton(new ControlAttr(" ADD NEW ",100d,42d));
		_addNewBtn.setOnAction(this::handleNewVendor);
		_vendorLayoutToolBar.getItems().add(_addNewBtn);
		
		
	}
	
	private void searchVendor(ActionEvent event) {
	     // Button was clicked, do something...
		Vendor _vendorDummy =  new Vendor();
		_vendorDummy.setVname(_vendorSearchText.getText());
		List<Vendor> resultList = vendorService.searchVendor(_vendorDummy);
		vendorData = FXCollections.observableArrayList(resultList);
		_vendorListTable.setItems(vendorData);
		if(!resultList.isEmpty())
			vendorDetailsController.getVendorDetailsDisplayView(resultList.get(0));
		else
	 		vendorDetailsController.getVendorDetailsDisplayView(new Vendor());
	 		
	}
	
	
	/**
	 * Called when the user clicks the new button. Opens a dialog to edit
	 * details for a new vendor.
	 */

	@FXML
	private void handleNewVendor(ActionEvent event) {
		vendorDetailsController.getVendorDetailsEditView();		
	}
	

	@Override
	public Node  loadView() throws IOException {
		return viewFactory.load(ViewPath.VIEW_LAYOUT);
	}
	
	
	

}
