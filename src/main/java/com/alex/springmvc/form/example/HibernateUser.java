package com.alex.springmvc.form.example;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Repository;

/**
 * 
 * <!-- HibernateValidator配置 需要在classpath路径下有hibernateValidator.properties文件绑定需要验证的字段-->
 * 	<!--如 
 * 		NotEmpty.hibernateUser.name = Name is required!
 * 		Range.hibernateUser.age = Age value must be between 6 and 150!
 * 		Range.hibernateUser.id = Id value must be between 6 and 150!
 * 		NotEmpty.hibernateUser.id = Id is required!
 * 		声明这个检查是NotEmpty还是Range，在相应的实体类中，写上注解声明该字段做什么检查
 * 	 -->
 * 
 * @author xiaoming
 *
 */
@Repository
public class HibernateUser {
	@Range(min = 7, max = 150)
	private Integer age;
	@NotEmpty
	private String name;
	@Range(min = 1, max = 250)
	private Integer id;

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getAge() {
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
}
