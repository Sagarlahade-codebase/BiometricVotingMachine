package com.project.bean;

import java.io.InputStream;

public class CandidateBean {

	int id;
	String fullname,party;
	InputStream is;
	
	
	
	
	
	
	public CandidateBean(int id, String fullname, String party, InputStream is) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.party = party;
		this.is = is;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public InputStream getIs() {
		return is;
	}
	public void setIs(InputStream is) {
		this.is = is;
	}
	
	
	
}
