package com.sapphire.org.config;

import java.io.IOException;

import javafx.scene.Node;

public abstract class AbstractViewFactory {	
	
	protected abstract Node load(String fxmlPath) throws IOException;
	

}
