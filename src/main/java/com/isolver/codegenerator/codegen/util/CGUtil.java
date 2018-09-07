package com.isolver.codegenerator.codegen.util;
/**
 * Class Generator Util
 * */
public class CGUtil {
	public static String genRepoName(ClassEntry ce) {
		return genSimpleClassType(ce.getClassName()) + "Repo";
	}
	
	public static String genSimpleClassType(String type) {
		int idx = type.lastIndexOf(".");
		return type.substring(idx + 1);
	}

	public static void addLineBreak(StringBuffer body) {
		body.append('\r').append('\n');
	}

	public static void addLineBreak(StringBuffer body, int num) {
		for (int i = 0; i < num; i++) {
			addLineBreak(body);
		}
	}
}
