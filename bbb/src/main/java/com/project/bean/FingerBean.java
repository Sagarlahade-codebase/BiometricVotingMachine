package com.project.bean;

public class FingerBean {

	private String orgFile;
	private String grayFile;
	private String binaryFile;
	private String thinFile;
	private String refineFile;
	private int buffcount;
	private int fkid;
	
	
	
	
	
	
	
	public FingerBean(String orgFile, String grayFile, String binaryFile, String thinFile, String refineFile,
			int buffcount, int fkid) {
		super();
		this.orgFile = orgFile;
		this.grayFile = grayFile;
		this.binaryFile = binaryFile;
		this.thinFile = thinFile;
		this.refineFile = refineFile;
		this.buffcount = buffcount;
		this.fkid = fkid;
	}



	public String getOrgFile() {
		return orgFile;
	}



	public void setOrgFile(String orgFile) {
		this.orgFile = orgFile;
	}



	public String getGrayFile() {
		return grayFile;
	}



	public void setGrayFile(String grayFile) {
		this.grayFile = grayFile;
	}



	public String getBinaryFile() {
		return binaryFile;
	}



	public void setBinaryFile(String binaryFile) {
		this.binaryFile = binaryFile;
	}



	public String getThinFile() {
		return thinFile;
	}



	public void setThinFile(String thinFile) {
		this.thinFile = thinFile;
	}



	public String getRefineFile() {
		return refineFile;
	}



	public void setRefineFile(String refineFile) {
		this.refineFile = refineFile;
	}



	public int getBuffcount() {
		return buffcount;
	}



	public void setBuffcount(int buffcount) {
		this.buffcount = buffcount;
	}



	public int getFkid() {
		return fkid;
	}



	public void setFkid(int fkid) {
		this.fkid = fkid;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
