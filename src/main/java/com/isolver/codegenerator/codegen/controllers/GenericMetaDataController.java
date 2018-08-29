package com.isolver.codegenerator.codegen.controllers;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Id;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.isolver.codegenerator.codegen.util.EntityNotFoundException;
import com.isolver.codegenerator.codegen.util.RecordEntry;

@RestController
public class GenericMetaDataController {
	// to do: needs to pull all the column names, data types, id or EmbeddedId 
	//
	public static final String PACKAGE_NAME = "com.isolver.codegenerator.codegen.entities";
	public static final String SUID= "serialVersionUID";
	@GetMapping(path = "/isolver/generic/{className}")
	public List<RecordEntry> getGenericEntityInfo(@PathVariable String className) {
		className =PACKAGE_NAME + "." + className;
		return retrieveClassInfo(className);
	}
	private List<RecordEntry> retrieveClassInfo(String className) {
		Class cl = null;
		
		try {
			cl = Class.forName(className);
			ArrayList<RecordEntry> list = new ArrayList<>();
			for (Field fl : cl.getDeclaredFields()) {
				if(fl.getName().equals(SUID))
					continue;
				String name = fl.getName();
				String type = fl.getType().getName();
				Column column = fl.getAnnotation( Column.class);
				String columnName=null;
				if(column!=null) {
					columnName =column.name();
				}
				Id id = fl.getAnnotation( Id.class);
				boolean isId= id==null? false:true;

				EmbeddedId emid = fl.getAnnotation( EmbeddedId.class);
				boolean isemid= emid==null? false:true;
				RecordEntry entry = new RecordEntry();
				entry.setName(name);
				entry.setType(type);
                entry.setColname(columnName);
                entry.setId(isId);
                entry.setEmbeddedId(isemid);
                
				if(isemid) {
					entry.setEmbeddedContent(this.retrieveClassInfo(type));
				}
			
				list.add(entry);

			}
			return list;

		} catch (ClassNotFoundException e) {
			throw new EntityNotFoundException("The class " + className +" does not exist!");
		}
	}

}
