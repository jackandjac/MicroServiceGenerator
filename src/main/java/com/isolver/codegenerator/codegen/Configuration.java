package com.isolver.codegenerator.codegen;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("isolvers.classinfo")
public class Configuration {
   private String package_name;

public String getPackage_name() {
	return package_name;
}

public void setPackage_name(String package_name) {
	this.package_name = package_name;
}
   
}
