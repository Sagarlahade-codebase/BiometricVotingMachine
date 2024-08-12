package com.project.daoImplementation;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.project.bean.CandidateBean;
import com.project.bean.FingerBean;
import com.project.bean.Register;
import com.project.daoInterface.UserInterface;
import com.project.dbConnection.Database;

public class UserImpl implements UserInterface {

	
	Connection conn=null;
	String query="";
	Statement s=null;
	PreparedStatement ps=null;
	boolean flag=false;
	int i=0;
	ResultSet rs=null;
	@Override
	public int registerUser(Register rb) {
	
		
		query="insert into user(id,fname,lname,username,password,email,mobile,addharcard,birthdate) values(null,?,?,?,?,?,?,?,?)";
		try {
			conn=Database.getConnection();
			ps=conn.prepareStatement(query);
			//System.out.println("rb.getAddhar()::"+rb.getAddhar());
			ps.setString(1, rb.getfName());
			ps.setString(2, rb.getlName());
			ps.setString(3, rb.getUsername());
			ps.setString(4, rb.getPassword());
			ps.setString(5, rb.getEmail());
			ps.setString(6, rb.getMobile());
			ps.setString(7, rb.getAddhar());
			//ps.setDate(8, (Date) rb.getBirthdate());
			ps.setString(8, rb.getBirthdate1());
			i=ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return i;
	}

	@Override
	public int checkUser(String uname, String email, String mobile) {
		
		conn=Database.getConnection();
		query="select username,email,mobile from user";
		try{
			
			s=conn.createStatement();
			rs=s.executeQuery(query);
			while(rs.next())
			{
				String username=rs.getString(1);
				String mail=rs.getString(2);
				String mob=rs.getString(3);
				if(username.equals(uname))
				{
					 i=1;
					 break;
				}else if(mail.equals(email))
				{
					 i=2;
					 break;
				}else if(mob.equals(mobile))
				{
					 i=3;
					 break;
				}else{
					 i=0;
					 break;
				}
			}
			
		}catch (Exception e) {
					e.printStackTrace();
		}
		
		return i;
	}

	@Override
	public int getRegisterUserId() {
		
		conn=Database.getConnection();
		query="select id from user";
		try{
			
			s=conn.createStatement();
			rs=s.executeQuery(query);
			while(rs.next())
			{
				i=rs.getInt(1);
			}
		
		
	}catch(Exception e)
		{
		e.printStackTrace();
		}

	
		return i;
	}

	@Override
	public int uploadFingerPrint(FingerBean rb) {
		query="insert into finger(id, originalfinger, grayfinger, binaryfinger, thinfinger, refinefinger, buffcount, fkid) values(null,?,?,?,?,?,?,?)";
		try {
			conn=Database.getConnection();
			ps=conn.prepareStatement(query);
			//System.out.println("rb.getAddhar()::"+rb.getAddhar());
			ps.setString(1, rb.getOrgFile());
			ps.setString(2, rb.getGrayFile());
			ps.setString(3, rb.getBinaryFile());
			ps.setString(4, rb.getThinFile());
			ps.setString(5, rb.getRefineFile());
			ps.setInt(6, rb.getBuffcount());
			ps.setInt(7, rb.getFkid());
			i=ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return i;
	}

	@Override
	public int loginUser(String username, String pass) {
		conn=Database.getConnection();
		query="select  id from user where username='"+username+"' AND password='"+pass+"'";
		try{
			
			s=conn.createStatement();
			rs=s.executeQuery(query);
			while(rs.next())
			{
				i=rs.getInt(1);
			}
		
		
	}catch(Exception e)
		{
		e.printStackTrace();
		}

	
		return i;
	}

	@Override
	public ArrayList<String> getAllFingerprint(int id) {
		conn=Database.getConnection();
		query="select originalfinger from finger where fkid="+id;
		ArrayList<String> al=new ArrayList<>();
		try{
			
			s=conn.createStatement();
			rs=s.executeQuery(query);
			while(rs.next())
			{
				al.add(rs.getString(1));
			}
		
		
	}catch(Exception e)
		{
			e.printStackTrace();
		}

	
		return al;
	}

	@Override
	public String getEmail(int id) {
		conn=Database.getConnection();
		query="select email from user where id="+id;
		String mail="";
		try{
			
			s=conn.createStatement();
			rs=s.executeQuery(query);
			while(rs.next())
			{
				mail=rs.getString(1);
			}
		
		
	}catch(Exception e)
		{
		e.printStackTrace();
		}

	
		return mail;
	}

	@Override
	public int checkParty(String party) {

		conn=Database.getConnection();
		query="select id from candidate where party='"+party+"'";
		int id=0;
		try{
			
			s=conn.createStatement();
			rs=s.executeQuery(query);
			while(rs.next())
			{
				id=rs.getInt(1);
			}
		
		
	}catch(Exception e)
		{
		e.printStackTrace();
		}

	
		return id;
	}



	@Override
	public int insertcandidate(InputStream is, String fullname, String party) {
		query="insert into candidate(id, name, party, imgfile) values(null,?,?,?)";
		try {
			conn=Database.getConnection();
			ps=conn.prepareStatement(query);
			//System.out.println("rb.getAddhar()::"+rb.getAddhar());
			ps.setString(1, fullname);
			ps.setString(2, party);
			ps.setBlob(3, is);
			
			i=ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return i;
	}

	@Override
	public ArrayList<CandidateBean> getCandidateList() {
		conn=Database.getConnection();
		query="select * from candidate";
		CandidateBean cb=null;
		ArrayList<CandidateBean> al=new ArrayList<>();
		try{
			
			s=conn.createStatement();
			rs=s.executeQuery(query);
			while(rs.next())
			{
				cb=new CandidateBean(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBinaryStream(4));
				al.add(cb);
			}
		
		
	}catch(Exception e)
		{
		e.printStackTrace();
		}

	
		return al;
	}

	@Override
	public InputStream getImageFile(int id) {
		conn=Database.getConnection();
		query="select imgfile from candidate where id="+id;
		InputStream is=null;
		
		try{
			
			s=conn.createStatement();
			rs=s.executeQuery(query);
			while(rs.next())
			{
				is=rs.getBinaryStream(1);
			}
		
		
	}catch(Exception e)
		{
		e.printStackTrace();
		}

	
		return is;
	}

	@Override
	public int removeCandidate(String id) {
		conn=Database.getConnection();
		query="Delete from candidate where id="+id;
		try{
			
			s=conn.createStatement();
			i=s.executeUpdate(query);
		
	}catch(Exception e)
		{
		e.printStackTrace();
		}

	
		return i;
	}

	@Override
	public int updateVote(String id) {
		conn=Database.getConnection();
		query="update vote set countvote=concat(countvote+1) where candidate="+id;
		try{
			
			s=conn.createStatement();
			i=s.executeUpdate(query);		
		
	}catch(Exception e)
		{
		e.printStackTrace();
		}

	
		return i;
	
	}

	@Override
	public int insertVote(String id) {
		query="insert into vote(id, candidate, countvote) values(null,?,?)";
		try {
			conn=Database.getConnection();
			ps=conn.prepareStatement(query);
			//System.out.println("rb.getAddhar()::"+rb.getAddhar());
			ps.setInt(1, Integer.parseInt(id));
			ps.setInt(2, 1);
			
			
			i=ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return i;
	}

	@Override
	public int checkCandidateVote(String id) {
		conn=Database.getConnection();
		query="select  id from vote where candidate='"+id+"'";
		try{
			
			s=conn.createStatement();
			rs=s.executeQuery(query);
			while(rs.next())
			{
				i=rs.getInt(1);
			}
		
		
	}catch(Exception e)
		{
		e.printStackTrace();
		}

	
		return i;
	}

	@Override
	public ArrayList<CandidateBean> getResultList() {
		conn=Database.getConnection();
		query="SELECT c.name, c.party, v.countvote  from candidate c left join vote v on c.id=v.candidate order by countvote desc ";
		CandidateBean cb=null;
		ArrayList<CandidateBean> al=new ArrayList<>();
		try{
			
			s=conn.createStatement();
			rs=s.executeQuery(query);
			while(rs.next())
			{
				cb=new CandidateBean(rs.getInt(3), rs.getString(1), rs.getString(2), null);
				al.add(cb);
			}
		
		
	}catch(Exception e)
		{
		e.printStackTrace();
		}

	
		return al;
	}
	
}
