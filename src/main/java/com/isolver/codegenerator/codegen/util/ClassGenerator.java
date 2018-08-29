package com.isolver.codegenerator.codegen.util;

import java.io.File;

public class ClassGenerator {
	
	
	public void packageGen(String pname, File cur) {
	     String[] res=pname.split("\\.");
	     String path=cur.getAbsolutePath();
	     for(int i=0;i<res.length;i++) {
	        path=path+File.separator+res[i];
	     }
	     new File(path).mkdirs();
	}

}
