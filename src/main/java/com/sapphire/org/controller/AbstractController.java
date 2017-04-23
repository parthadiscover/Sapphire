package com.sapphire.org.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.Node;

public abstract  class  AbstractController {
	
	
	
	@FXML
	private Node _nroot;	

	
	protected Node getParentNode(){
		 return _nroot;
	}

	public abstract Node loadView() throws IOException;
	
	protected abstract void completeLayout();

}
