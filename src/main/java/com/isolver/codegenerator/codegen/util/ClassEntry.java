 package com.isolver.codegenerator.codegen.util;

import java.util.List;

import javax.persistence.Embeddable;

public class ClassEntry {
	// Table Entity NamedQuery @Embeddable
	private String className;
	private String TableName;
	private String packageName;
	private boolean entity;
	private boolean embeddable;
	private List<RecordEntry> records;
	
	
	
	public ClassEntry() {

	}
	
	public ClassEntry(String className, String tableName, String packageName, boolean entity, boolean embeddable,
			List<RecordEntry> records) {
		super();
		this.className = className;
		TableName = tableName;
		this.packageName = packageName;
		this.entity = entity;
		this.embeddable = embeddable;
		this.records = records;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getTableName() {
		return TableName;
	}
	public void setTableName(String tableName) {
		TableName = tableName;
	}
	public boolean isEntity() {
		return entity;
	}
	public void setEntity(boolean entity) {
		this.entity = entity;
	}
	public boolean isEmbeddable() {
		return embeddable;
	}
	public void setEmbeddable(boolean embeddable) {
		this.embeddable = embeddable;
	}
	public List<RecordEntry> getRecords() {
		return records;
	}
	public void setRecords(List<RecordEntry> records) {
		this.records = records;
	}
	

}
