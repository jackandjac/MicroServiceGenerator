package com.isolver.codegenerator.codegen.util;

import java.util.List;

public class ClassTableMapping {
	private String sourceClassName;
	private String targetClassName;
	private String sourceTableName;
	private String targetTableName;
	private List<SimplePairedEntry> list;
	
	public String getSourceClassName() {
		return sourceClassName;
	}
	public void setSourceClassName(String sourceClassName) {
		this.sourceClassName = sourceClassName;
	}
	public String getTargetClassName() {
		return targetClassName;
	}
	public void setTargetClassName(String targetClassName) {
		this.targetClassName = targetClassName;
	}
	public String getSourceTableName() {
		return sourceTableName;
	}
	public void setSourceTableName(String sourceTableName) {
		this.sourceTableName = sourceTableName;
	}
	public String getTargetTableName() {
		return targetTableName;
	}
	public void setTargetTableName(String targetTableName) {
		this.targetTableName = targetTableName;
	}
	public List<SimplePairedEntry> getList() {
		return list;
	}
	public void setList(List<SimplePairedEntry> list) {
		this.list = list;
	}
	public ClassTableMapping(String sourceClassName, String targetClassName, String sourceTableName,
			String targetTableName, List<SimplePairedEntry> list) {
		super();
		this.sourceClassName = sourceClassName;
		this.targetClassName = targetClassName;
		this.sourceTableName = sourceTableName;
		this.targetTableName = targetTableName;
		this.list = list;
	}
	public ClassTableMapping() {
		super();
		// TODO Auto-generated constructor stub
	}

}
