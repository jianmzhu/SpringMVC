package com.alex.springmvc.xmlgenerate.example;

import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class XmlUser {
	private String name;
	private int id;
	private Map<String,String> testMap;
	private List<String> testList;
	private double yuans;
	public String getName() {
		return name;
	}
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	@XmlElement
	public void setId(int id) {
		this.id = id;
	}
	public Map<String, String> getTestMap() {
		return testMap;
	}
	@XmlElement
	public void setTestMap(Map<String, String> testMap) {
		this.testMap = testMap;
	}
	public List<String> getTestList() {
		return testList;
	}
	@XmlElement
	public void setTestList(List<String> testList) {
		this.testList = testList;
	}
	public double getYuans() {
		return yuans;
	}
	@XmlElement
	public void setYuans(double yuans) {
		this.yuans = yuans;
	}
	
	
}
