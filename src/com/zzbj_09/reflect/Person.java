package com.zzbj_09.reflect;

import java.io.Serializable;

public class Person implements Serializable,TestInterface{
	private Long id;
	public String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Person(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Person() {
		this.id=100L;
		this.name="afdf";
	}
	private Person(String name) {
		this.name=name;
	}
	private Person(Long _id) {
		this.id=_id;
	}
	private String  getToString(){
		return "to string";
	}
}
