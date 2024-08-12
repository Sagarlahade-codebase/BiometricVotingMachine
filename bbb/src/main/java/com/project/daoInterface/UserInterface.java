package com.project.daoInterface;

import java.io.InputStream;
import java.util.ArrayList;

import com.project.bean.CandidateBean;
import com.project.bean.FingerBean;
import com.project.bean.Register;

public interface UserInterface {

	
	public int registerUser(Register rb);
	
	public int checkUser(String uname, String email, String mobile);
	
	public int getRegisterUserId();
	
	public int uploadFingerPrint(FingerBean fb);
	
	public int loginUser(String username, String pass);
	
	public ArrayList<String> getAllFingerprint(int id);
	
	public String getEmail(int id);
	
	public int checkParty(String party);
	
	public int insertcandidate(InputStream is, String fullname,String party);
	
	public ArrayList<CandidateBean> getCandidateList();
	
	public InputStream getImageFile(int id);
	
	public int removeCandidate(String id);
	
	public int updateVote(String id);
	
	public int insertVote(String id);
	
	public int checkCandidateVote(String id);
	
	public ArrayList<CandidateBean> getResultList();
}
