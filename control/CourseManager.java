package control;

import java.util.ArrayList;

import entity.Course;
import entity.Session;

public class CourseManager {
	private ArrayList<Course> courses;
	
	private Course currentCourse;
	
	public CourseManager(){
		initialize();
	}
	
	public void initialize(){
		courses=new ArrayList<Course>();
		loadCourses();
	}
	
	public void loadCourses(){
		// retrieve courses from file
		ArrayList ls=retrieveCourses();
		if (ls==null) return;
		for (Object o:ls){
			courses.add((Course)o);
		}
	}
	
	public ArrayList<Course> getCourses(){
		return courses;
	}
	
	public boolean addCourse(String newCourseCode, String newCourseName){
		for (Course c:courses){
			if (c.getCode().equals(newCourseCode)){
				// already added
				return false;
			}
		}
		// not added , now add it
		courses.add(new Course(newCourseCode, newCourseName));
		return true;
	}
	
	public void storeCourses(){
		StorageManager StMgr=new StorageManager(new SystemConfig());
		StMgr.store("Course",courses);
	}
	
	private ArrayList retrieveCourses(){
		StorageManager StMgr=new StorageManager(new SystemConfig());
		try{
			ArrayList ls=(ArrayList)StMgr.read("Course");
			return ls;
		}
		catch (Exception e){
			e.printStackTrace();
			return null;
		}
		
	}

	public Course getCurrentCourse() {
		return currentCourse;
	}

	public boolean setCurrentCourse(String code) {
		for (Course c:courses){
			if (c.getCode().equals(code)){
				// find the course to edit
				currentCourse=c;
				return true;
			}
		}
		return false;
	}
	
	public void addSessionToCurrentCourse(int type,String groupId){
		currentCourse.addSession(type, groupId);
	}
	
	public String getSessionInfo(){
		ArrayList<Session> sl=currentCourse.getSessions();
		String info="";
		for (Session s:sl){
			info +=s.toString() + "\n";
		}
		return info;
	}
}
