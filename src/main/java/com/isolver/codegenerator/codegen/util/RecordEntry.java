package com.isolver.codegenerator.codegen.util;

import java.lang.annotation.Annotation;
import java.util.List;

public class RecordEntry {
    private String name;
    private String type;
	private String colname;
	private int length;
    private boolean id;
    private boolean embeddedId;
    private boolean temporal;
    private boolean nullable;
    private boolean insertable;
    private boolean updatable;
	private ClassEntry embeddedContent;

	public RecordEntry() {
		super();
		
	}

	public RecordEntry(String name, String type, String colname, int length, boolean id, boolean embeddedId,
			boolean temporal, boolean nullable, boolean insertable, boolean updatable,
			ClassEntry embeddedContent) {
		super();
		this.name = name;
		this.type = type;
		this.colname = colname;
		this.length = length;
		this.id = id;
		this.embeddedId = embeddedId;
		this.temporal = temporal;
		this.nullable = nullable;
		this.insertable = insertable;
		this.updatable = updatable;
		this.embeddedContent = embeddedContent;
	}

	public boolean isInsertable() {
		return insertable;
	}

	public void setInsertable(boolean insertable) {
		this.insertable = insertable;
	}

	public boolean isUpdatable() {
		return updatable;
	}

	public void setUpdatable(boolean updatable) {
		this.updatable = updatable;
	}

	public boolean getNullable() {
		return nullable;
	}

	public void setNullable(boolean nullable) {
		this.nullable = nullable;
	}

    



	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public boolean isTemporal() {
		return temporal;
	}
	public void setTemporal(boolean temporal) {
		this.temporal = temporal;
	}
	
    public ClassEntry getEmbeddedContent() {
		return embeddedContent;
	}
	public void setEmbeddedContent(ClassEntry embeddedContentg) {
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
