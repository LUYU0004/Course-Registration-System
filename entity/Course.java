package entity;

import java.io.Serializable;
import java.util.ArrayList;

public class Course implements Serializable {
	private String code;
	private String name;
	private ArrayList<Index> indices;
	private ArrayList<Session> sessions;
	private ArrayList<Assessment> assessments;
	
	public Course(){
		indices=new ArrayList<Index>();
		sessions=new ArrayList<Session>();
		assessments=new ArrayList<Assessment>();
	}
	
	public Course(String c,String n){
		code=c;
		name=n;
	}
	
	public String toString(){
		return code+" "+name;
	}
	
	public String getCode(){
		return code;
	}
	
	public void addSession(int type,String groupId){
		Session a=new Session(type,groupId);
		sessions.add(a);
	}

	public ArrayList<Index> getIndices() {
		return indices;
	}

	public void setIndices(ArrayList<Index> indices) {
		this.indices = indices;
	}

	public ArrayList<Session> getSessions() {
		return sessions;
	}

	public void setSessions(ArrayList<Session> sessions) {
		this.sessions = sessions;
	}

	public ArrayList<Assessment> getAssessments() {
		return assessments;
	}

	public void setAssessments(ArrayList<Assessment> assessments) {
		this.assessments = assessments;
	}
}
