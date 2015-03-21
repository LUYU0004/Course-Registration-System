package entity;

import java.io.Serializable;

public class Session implements Serializable{
	public static final int LECTURE=1;
	public static final int TUTORIAL=2;
	public static final int LAB=3;
	
	private int type;
	private String groupName;
	
	public Session(int t,String gd){
		type=t;
		groupName=gd;
	}
	
	public String toString(){
		String typeName="";
		if (type==1){
			typeName="LEC";
		}
		else if (type==2){
			typeName="TUT";
		}
		else{
			typeName="LAB";
		}
		return typeName + ": " + groupName;
	}
//	private int capacity;
//	private Course course;
}
