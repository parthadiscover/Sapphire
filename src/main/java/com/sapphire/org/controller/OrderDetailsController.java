package com.sapphire.org.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sapphire.org.config.ViewFactory;
import com.sapphire.org.constant.ViewPath;
import com.sapphire.org.model.Items;
import com.sapphire.org.model.OrderDetails;
import com.sapphire.org.service.OrderService;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

@Controller
public class OrderDetailsController extends AbstractController {
	
	
	@Autowired
	private ViewFactory viewFactory;
	
	@Autowired
	private OrderService orderService;
	
	@FXML
	private TableView _orderItemsTableView;
	
    @FXML
    private TableColumn<OrderDetails, Integer> _orderItemsTableViewCol_SrNo;
    @FXML
    private TableColumn<OrderDetails, String> _orderItemsTableViewCol_PrdNo;
    @FXML
    private TableColumn<OrderDetails, String> _orderItemsTableViewCol_Desc;
    @FXML
    private TableColumn<OrderDetails, Integer> _orderItemsTableViewCol_Qty;
    @FXML
    private TableColumn<OrderDetails, Double> _orderItemsTableViewCol_UnitPrc;
    @FXML
    private TableColumn<OrderDetails, Double> _orderItemsTableViewCol_NetPrc;
    @FXML
    private TableColumn<OrderDetails, Double> _orderItemsTableViewCol_VatAmt;
    @FXML
    private TableColumn<OrderDetails, Double> _orderItemsTableViewCol_GrsAmt;
	
	@FXML
	private TextField _orderScanText;
	
	
	@FXML
	private Button _orderScanBtn;
	
    private ObservableList<OrderDetails> _orderItemsTableViewList = FXCollections.observableArrayList();
    
    private  AnchorPane orderDetails;
    
    @FXML
	private void initialize() {
		
    	orderDetails = (AnchorPane)getParentNode();	
    	_orderItemsTableView.setItems(_orderItemsTableViewList);
		this.completeLayout();
		
	}

	@Override
	public Node loadView() throws IOException {
		return viewFactory.load(ViewPath.ORDER_DETAILS);
	}

	@Override
	protected void completeLayout() {
		// TODO Auto-generated method stub
		itemTableLayout();
	}
	
	
	 @FXML
	 private void processScan() {
	        System.out.println("Item Clicked :: "+_orderScanText.getText());
	        String _scannedBarCode = _orderScanText.getText();
	        Items _item =  new Items(_scannedBarCode);
	        OrderDetails orderDetails = orderService.prcoessBarCodeScan(_item);
	        _orderItemsTableViewList.add(orderDetails);	        
	        _orderScanText.setText("");
	    }
	 
	 
	 private void itemTableLayout(){
		 
		 
		 _orderItemsTableViewCol_SrNo.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper(_orderItemsTableView.getItems().indexOf(cellData.getValue()) + 1)); 		 
		 _orderItemsTableViewCol_PrdNo.setCellValueFactory(cellData -> cellData.getValue().getStringProperty(cellData.getValue().getItem().getItemBrcd()));
		 _orderItemsTableViewCol_Desc.setCellValueFactory(cellData -> cellData.getValue().getStringProperty(cellData.getValue().getItem().getItemDesc()));
		 _orderItemsTableViewCol_Qty.setCellValueFactory(cellData -> cellData.getValue().getIntegerProperty(cellData.getValue().getOrderItemQty()));
		 _orderItemsTableViewCol_UnitPrc.setCellValueFactory(cellData -> cellData.getValue().getDoubleProperty(cellData.getValue().getOrderItemSellPrc()));
		 _orderItemsTableViewCol_NetPrc.setCellValueFactory(cellData -> cellData.getValue().getDoubleProperty(cellData.getValue().getOrderItemNetPrc()));
		 _orderItemsTableViewCol_VatAmt.setCellValueFactory(cellData -> cellData.getValue().getDoubleProperty(cellData.getValue().getOrderItemVatAmt()));
		 _orderItemsTableViewCol_GrsAmt.setCellValueFactory(cellData -> cellData.getValue().getDoubleProperty(cellData.getValue().getOrderItemGrossPrc()));

	 }

}
