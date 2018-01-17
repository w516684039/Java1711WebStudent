package com.situ.student.entity;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {

	private Integer id;
	private String name;
	private Integer age;
	private String gender;
	private String address;
	private Date birthday;
	private Date addTime;// 入学时间，当前生成学生对象时间
	private String banji_id;

	public Student() {
		super();
	}
	
	
	public Student(String name, Integer age, String gender, String address, String banji) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.banji_id = banji;
	}


	public Student(String name, Integer age, String gender, String address) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}


	

	public Student(String name, Integer age, String gender, String address, Date birthday, Date addTime, String banji) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.birthday = birthday;
		this.addTime = addTime;
		this.banji_id = banji;
	}

	public Student(Integer id, String name, Integer age, String gender, String address, Date birthday, Date addTime,
			String banji) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.birthday = birthday;
		this.addTime = addTime;
		this.banji_id = banji;
	}


	public Student(Integer id, String name, Integer age, String gender, String address, Date birthday, Date addTime) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.birthday = birthday;
		this.addTime = addTime;
	}

	public Student(String name, Integer age, String gender, String address, Date birthday, Date addTime) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.birthday = birthday;
		this.addTime = addTime;
	}

	public Student(Integer id2, String name2, Integer age2, Object object, Object object2, Object object3,
			Banji banji2) {
		// TODO Auto-generated constructor stub
	}

	public String getBanji() {
		return banji_id;
	}

	public void setBanji(String banji) {
		this.banji_id = banji;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Integer getId() {
		return id;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	

	public Student(Integer id, String name, Integer age, String gender, String address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", address=" + address
				+ ", birthday=" + birthday + ", addTime=" + addTime + ", banji=" + banji_id + "]";
	}


	

}
