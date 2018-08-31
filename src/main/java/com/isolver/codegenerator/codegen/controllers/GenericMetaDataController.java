package com.isolver.codegenerator.codegen.controllers;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.isolver.codegenerator.codegen.util.ClassEntry;
import com.isolver.codegenerator.codegen.util.EntityClassGenerator;
import com.isolver.codegenerator.codegen.util.EntityNotFoundException;
import com.isolver.codegenerator.codegen.util.RecordEntry;

@RestController
public class GenericMetaDataController {
	// to do: needs to pull all the column names, data types, id or EmbeddedId 
	//
	public static final String PACKAGE_NAME = "com.isolver.codegenerator.codegen.entities";
	@Autowired
	private EntityClassGenerator entityClassGenerator;

	@GetMapping(path = "/isolver/generic/{className}")
	public ClassEntry getGenericEntityInfo(@PathVariable String className) {
		className =PACKAGE_NAME + "." + className;
		return entityClassGenerator.retrieveClassInfo(className);
	}
	@GetMapping(path = "/isolver/testing")
	public List<String> testService() {
		ArrayList<String> list=new ArrayList<String>();
		list.add( entityClassGenerator.genEmbeddableClassHeader("CommValPK"));
		list.add(entityClassGenerator.genEntityClassHeader("CommVal", "COMM_VAL"));
		return list;
	}
	@GetMapping(path = "/isolver/testclass/{className}")
	public String testClassGeneration(@PathVariable String className) {
		ClassEntry ce=entityClassGenerator.retrieveClassInfo(PACKAGE_NAME + "."+className);
		String content = entityClassGenerator.genClass(ce);
		System.out.println(content);
		return content;
	}


}
