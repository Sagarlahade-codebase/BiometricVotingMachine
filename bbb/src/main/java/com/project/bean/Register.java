package com.project.bean;

import java.util.Date;

public class Register {
	private String fName,lName,username,password,email,mobile,addhar,birthdate1;

	Date birthdate;
	public Register() {
		// TODO Auto-generated constructor stub
	}

	
	
	public String getBirthdate1() {
		return birthdate1;
	}



	public void setBirthdate1(String birthdate1) {
		this.birthdate1 = birthdate1;
	}



	public Date getBirthdate() {
		return birthdate;
	}



	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}



	public String getAddhar() {
		return addhar;
	}



	public void setAddhar(String addhar) {
		this.addhar = addhar;
	}



	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMobile() {
		return mobile;
	}



	public void setMobile(String mobile) {
		this.mobile = mobile;
	}



	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

}
