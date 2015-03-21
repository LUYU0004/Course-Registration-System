package entity;

import java.io.Serializable;

public class Assessment implements Serializable {
	public static final int COURSE_WORK=1;
	public static final int EXAM=2;
	
	private int weightage;
	private int type;
	private Course course;
}
