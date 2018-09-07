package com.isolver.codegenerator.codegen;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("isolvers.classinfo")
public class Configuration {
   private String package_name;
   private String entity_package_name;
   private String controller_package_name;
   
public String getController_package_name() {
	return controller_package_name;
}

public void setController_package_name(String controller_package_name) {
	this.controller_package_name = controller_package_name;
}

public String getEntity_package_name() {
	return entity_package_name;
}

public void setEntity_package_name(String entity_package_name) {
	this.entity_package_name = entity_package_name;
}

public String getPackage_name() {
	return package_name;
}

public void setPackage_name(String package_name) {
	this.package_name = package_name;
}
   
}
