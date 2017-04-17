package com.zzbj_09.reflect;

import org.junit.Before;

public class MyReflect {
	public String classname = "";

	public Class personClass = null;

	@Before
	public void init() throws ClassNotFoundException {
		classname = "com.zzbj_09.reflect.Person";
		personClass = Class.forName(classname);
	}
}
