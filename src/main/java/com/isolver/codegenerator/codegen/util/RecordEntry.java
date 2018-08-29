package com.isolver.codegenerator.codegen.util;

import java.lang.annotation.Annotation;
import java.util.List;

public class RecordEntry {
    private String name;
    private String type;
	private String colname;
    private boolean id;
    private boolean embeddedId;
    private List<RecordEntry> embeddedContent;
    

	public RecordEntry(String name, String type, String colname, boolean id, boolean embeddedId) {
		super();
		this.name = name;
		this.type = type;
		this.colname = colname;
		this.id = id;
		this.embeddedId = embeddedId;
	}
	public RecordEntry() {
		super();
		
	}
	
    public List<RecordEntry> getEmbeddedContent() {
		return embeddedContent;
	}
	public void setEmbeddedContent(List<RecordEntry> embeddedContentg) {
		this.embeddedContent = embeddedContentg;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getColname() {
		return colname;
	}
	public void setColname(String colname) {
		this.colname = colname;
	}
	public boolean isId() {
		return id;
	}
	public void setId(boolean id) {
		this.id = id;
	}
	public boolean isEmbeddedId() {
		return embeddedId;
	}
	public void setEmbeddedId(boolean embeddedId) {
		this.embeddedId = embeddedId;
	}

    

	
}
