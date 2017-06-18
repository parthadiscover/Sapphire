package com.sapphire.org.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sapphire.org.config.ViewFactory;
import com.sapphire.org.constant.ViewPath;
import com.sapphire.org.fxutils.BasicFxUtils;
import com.sapphire.org.fxutils.ControlAttr;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

@Controller
public class OrderLayoutController extends AbstractController {
	
	@Autowired
	private ViewFactory viewFactory;
	
	@Autowired
	private OrderDetailsController orderDetailsController;
	
	private  AnchorPane orderLayout;
	
    @FXML
    private ToolBar _orderLayoutToolBar;

	@Override
	public Node loadView() throws IOException {
		return viewFactory.load(ViewPath.ORDER_LAYOUT);		
	}
	
	
	@FXML
	private void initialize() {
		
		orderLayout = (AnchorPane)getParentNode();	
		this.completeLayout();
		
	}

	@Override
	protected void completeLayout(){
	//  Add New Order  Button
		Button _addNewBtn = (Button) BasicFxUtils.getAddButton(new ControlAttr(" Order ",100d,42d));
		_addNewBtn.setOnAction(this::handleNewOrder);
		_orderLayoutToolBar.getItems().add(_addNewBtn);
		
		
	}
	
	
	@FXML
	private void handleNewOrder(ActionEvent event) {
		addOrderDetailsDisplayView();
	}
	
	
	private void addOrderDetailsDisplayView(){
		try {
			Node orderDetailsView = orderDetailsController.loadView();
			ObservableList<Node> anchorList =  orderLayout.getChildren();
			BorderPane boderPane = (BorderPane)(anchorList.get(0));
			VBox centreVbox = (VBox)boderPane.getCenter();		
			centreVbox.getChildren().add(orderDetailsView);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
