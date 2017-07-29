package com.alex.springmvc.jsongenerate.example;

import java.util.List;
import java.util.Map;

public class JsonUser {
	private String name;
	private int id;
	private Map<String,String> testMap;
	private List<String> testList;
	private double yuans;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Map<String, String> getTestMap() {
		return testMap;
	}
	public void setTestMap(Map<String, String> testMap) {
		this.testMap = testMap;
	}
	public List<String> getTestList() {
		return testList;
	}
	public void setTestList(List<String> testList) {
		this.testList = testList;
	}
	public double getYuans() {
		return yuans;
	}
	public void setYuans(double yuans) {
		this.yuans = yuans;
	}
	
	
}
