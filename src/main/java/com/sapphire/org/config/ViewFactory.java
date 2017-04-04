package com.sapphire.org.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

@Component("viewFactory")
public class ViewFactory {

	@Autowired
	private ConfigurableApplicationContext applicationContext;
	


	public  Node load(String fxmlPath) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ViewFactory.class.getResource(fxmlPath));
        fxmlLoader.setControllerFactory(applicationContext::getBean);
        System.out.println(applicationContext+"===="+fxmlPath);
        return fxmlLoader.load();
	}
	
}
