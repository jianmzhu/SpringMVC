package com.alex.springmvc.form.example;

import java.util.Arrays;

import org.springframework.stereotype.Repository;

@Repository
public class Student {
	private Integer id;
	private String name;
	private Integer age;
	private String password;
	private String address;
	//checkbox选项中，该值必须为boolean值，不然页面标签会报错
	private boolean isMaster;
	private String[] restLessons;
	private String gender;
	//多项单选按钮的值应该为字符串
	private String favoriteNumber;
	private String country;
	private String[] skills;
	private String hiddenId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean getIsMaster() {
		return isMaster;
	}
	public void setIsMaster(boolean isMaster) {
		this.isMaster = isMaster;
	}
	public String[] getRestLessons() {
		return restLessons;
	}
	public void setRestLessons(String[] restLessons) {
		this.restLessons = restLessons;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getFavoriteNumber() {
		return favoriteNumber;
	}
	public void setFavoriteNumber(String favoriteNumber) {
		this.favoriteNumber = favoriteNumber;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String[] getSkills() {
		return skills;
	}
	public void setSkills(String[] skills) {
		this.skills = skills;
	}
	
	public String getHiddenId() {
		return hiddenId;
	}
	public void setHiddenId(String hiddenId) {
		this.hiddenId = hiddenId;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age
				+ ", password=" + password + ", address=" + address
				+ ", isMaster=" + isMaster + ", restLessons="
				+ Arrays.toString(restLessons) + ", gender=" + gender
				+ ", favoriteNumber=" + favoriteNumber + ", country=" + country
				+ ", skills=" + Arrays.toString(skills) + ", hiddenId="
				+ hiddenId + "]";
	}
	
}
