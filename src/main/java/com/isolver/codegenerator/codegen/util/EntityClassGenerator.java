package com.isolver.codegenerator.codegen.util;

import java.io.File;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.isolver.codegenerator.codegen.Configuration;
@Component
public class EntityClassGenerator {
	public static final String SUID= "serialVersionUID";
	public static final String EMBEDDABLE_TAG="@Embeddable";
	public static final String ENTITY_TAG="@Entity";
	public static final String SUID_TEMPLATE="private static final long serialVersionUID = 1L;";
	
	@Autowired
	Configuration configuration;
	public ClassEntry retrieveClassInfo(String className) {
		Class cl = null;
		ArrayList<RecordEntry> list = new ArrayList<>();
		ClassEntry classEntry=new ClassEntry();
		try {
			cl = Class.forName(className);
			Entity tentity =(Entity) cl.getAnnotation(Entity.class);
			
			boolean isEntity= (tentity !=null);
		
			Table ttable =(Table) cl.getAnnotation(Table.class);
			
			String tableName= null;
			if(ttable!=null) {
				tableName=ttable.name();
			}
			
			boolean embeddable =  cl.getAnnotation(Embeddable.class)==null ? false:true;
			classEntry.setClassName(className);
			classEntry.setEntity(isEntity);
			classEntry.setEmbeddable(embeddable);
			classEntry.setTableName(tableName);
			
					
			for (Field fl : cl.getDeclaredFields()) {
				if(fl.getName().equals(SUID))
					continue;
				String name = fl.getName();
				String type = fl.getType().getName();
				Column column = fl.getAnnotation( Column.class);
				String columnName=null;
				boolean nullable = false;
				boolean insertable = false;
				boolean updatable = false;
				int length=0;
				if(column!=null) {
					columnName =column.name();
					length=column.length();
					nullable =column.nullable();
					insertable=column.insertable();
					updatable=column.updatable();
				}
			
				Id id = fl.getAnnotation( Id.class);
				boolean isId= id==null? false:true;

				EmbeddedId emid = fl.getAnnotation( EmbeddedId.class);
				boolean isEmid= emid==null? false:true;
				
				Temporal temporal = fl.getAnnotation( Temporal.class);
				boolean isTemp= temporal==null? false:true;
				RecordEntry entry = new RecordEntry();
				entry.setName(name);
				entry.setType(type);
                entry.setColname(columnName);
                entry.setId(isId);
                entry.setEmbeddedId(isEmid);
                entry.setTemporal(isTemp);
                entry.setLength(length);
                entry.setNullable(nullable);
                entry.setInsertable(insertable);
                entry.setUpdatable(updatable);
                
				if(isEmid) {
					entry.setEmbeddedContent(this.retrieveClassInfo(type));
				}
			
				list.add(entry);

			}
			classEntry.setRecords(list);
			return classEntry;

		}catch (ClassNotFoundException e) {
			throw new EntityNotFoundException("The class " + className +" does not exist!");
		}
	}
	
	public void genEntity(ClassEntry entry, OutputStream out) {
		PrintWriter pout =new PrintWriter(out,true);
	}
	
	private String genImportLib() {

		StringBuffer sb =new StringBuffer("");
		sb.append("import java.io.Serializable;").append('\r').append('\n');
		sb.append("import javax.persistence.*;").append('\r').append('\n');
		sb.append("import java.math.*;").append('\r').append('\n');
		sb.append("import java.util.*;").append('\r').append('\n');
		return sb.toString();
	}
	
	private String genPackageInfo() {
		return "package " + this.configuration.getPackage_name()+";";
	}

	
	public String genEmbeddableClassHeader(String className) {
		StringBuffer header =new StringBuffer("");
		header.append(this.genPackageInfo());
		header.append('\r').append('\n');
		header.append('\r').append('\n');
		
		header.append(this.genImportLib());
		header.append('\r').append('\n');
		header.append('\r').append('\n');
		
		header.append(EMBEDDABLE_TAG).append('\r').append('\n');
		header.append(genericClassHeader(className));
		header.append(SUID_TEMPLATE).append('\r').append('\n');
        header.append('\r').append('\n');
        header.append('\r').append('\n');
        header.append('\r').append('\n');
        return header.toString();
		
	}
	
	public String genClassBody(List<RecordEntry> entries){
		StringBuffer body =new StringBuffer("");
		
		
		
		return body.toString();
	}
	
	private String genField(RecordEntry entry) {
		StringBuffer field=new StringBuffer("");
		if(entry.isEmbeddedId()) {
			
		}else if(entry.isId()) {
			
		}else {
			
		}
		return field.toString();
	}

	private String genericClassHeader(String className) {
		StringBuffer sb =new StringBuffer("");
		return sb.append("public class ").append(className).append(" implements Serializable { ").append('\r').append('\n').toString();
	}
	
	public String end(){
		return " } ";	
	}
	
	public String genEntityClassHeader(String className,String tableName) {

		StringBuffer header = new StringBuffer("");
		
		header.append(this.genPackageInfo());
		header.append('\r').append('\n');
		header.append('\r').append('\n');
		
		header.append(this.genImportLib());
		header.append('\r').append('\n');
		header.append('\r').append('\n');
		
		header.append(ENTITY_TAG);
		header.append('\r').append('\n');
		
		header.append(this.genTableTag(tableName));
		header.append('\r').append('\n');
		
		header.append(this.genNamedQueryTag(className));
		header.append('\r').append('\n');
		
		header.append(this.genericClassHeader(className));
		header.append('\r').append('\n');
		
		header.append(SUID_TEMPLATE).append('\r').append('\n');
		header.append('\r').append('\n');
		header.append('\r').append('\n');
		header.append('\r').append('\n');
        return header.toString();
		

	}
	public String genTableTag(String tableName) {
		return "@Table(name=\""+tableName+"\")";
	}
	
	public String genNamedQueryTag(String className) {
	
		char initial=className.toLowerCase().charAt(0);
		return "@NamedQuery(name=\"" + className+".findAll\", query=\"SELECT "+initial+ " from " + className+" "+initial+"\")";
	}

}
