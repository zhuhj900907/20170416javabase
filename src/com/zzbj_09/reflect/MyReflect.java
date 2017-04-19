package com.zzbj_09.reflect;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;

public class MyReflect {
	public String classname = "";

	public Class personClass = null;

	@Before
	public void init() throws ClassNotFoundException {
		classname = "com.zzbj_09.reflect.Person";
		personClass = Class.forName(classname);
	}
	@Test
	public void getClassName(){
		System.out.println(personClass);
	}
	
	@Test
	public void getNewInstance() throws InstantiationException, IllegalAccessException{
		System.out.println(personClass.newInstance());
	}
	/***
	 * 构造函数
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws IllegalArgumentException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@Test
	public void getPublicConstructer() throws SecurityException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException{
		Constructor constructor = personClass.getConstructor(Long.class,String.class);
		Person person = (Person)constructor.newInstance(100L,"dddd");
		System.out.println(person.getId());
		System.out.println(person.getName());
	}
	/***
	 * 拿到私有的构造函数
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws IllegalArgumentException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@Test
	public void getPrivateConstructer() throws SecurityException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException{
		Constructor constructor = personClass.getDeclaredConstructor(String.class);
		constructor.setAccessible(true);//强制取消检测
		Person person = (Person)constructor.newInstance("dddd");
		System.out.println(person.getName());
	}
/**
 * 获得共有的属性
 * @throws SecurityException
 * @throws NoSuchMethodException
 * @throws IllegalArgumentException
 * @throws InstantiationException
 * @throws IllegalAccessException
 * @throws InvocationTargetException
 * @throws NoSuchFieldException
 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void getNoPrivateField() throws Exception {
		Constructor constructor = personClass.getConstructor(Long.class,String.class);
		Object obj = constructor.newInstance(100L,"dddd");
		
		Field field = personClass.getField("name");
		field.set(obj,"zhuhj");
		System.out.println(field.get(obj));
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void getPrivateField() throws Exception {
		Constructor constructor = personClass.getConstructor(Long.class);
		Object obj = constructor.newInstance(100L);
		
		Field field2 = personClass.getDeclaredField("id");
		field2.setAccessible(true);
		field2.set(obj,100000L);
		System.out.println(field2.get(obj));
	}
	/***
	 * 获得到共有的方法
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void getNoPrivateMethod() throws Exception {
		System.out.println(personClass.getMethod("toString"));
		Object obj = personClass.newInstance();
		
		Object object = personClass.getMethod("toString").invoke(obj);
		System.out.println(object);
	}
	/***
	 * 获得私有的方法
	 * @throws Exception
	 */
	@Test
	public void getPrivateMethod() throws Exception {
		Object obj = personClass.newInstance();
		
		Method method =  personClass.getDeclaredMethod("getToString");
		method.setAccessible(true);
		Object value = method.invoke(obj);
		System.out.println(value);
	}
	/****
	 * 获得其他的方法
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	@Test
	public void getOtherMethod() throws Exception {
		System.out.println(personClass.getClassLoader());
		Class[] interfaces = personClass.getInterfaces();
		for(Class class1:interfaces){
			System.out.println(class1);
		}
		//当前类的直接父类
		System.out.println(personClass.getGenericSuperclass());
		//从根目录下取
		System.out.println(personClass.getResourceAsStream("/log4j.properties"));
		System.out.println(personClass.getResourceAsStream("log4j1.properties"));
	}
}
