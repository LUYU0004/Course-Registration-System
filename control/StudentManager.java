package control;

import java.util.ArrayList;

import entity.Student;

public class StudentManager {
	private ArrayList<Student> students;
	private Student currentStudent;
	
	public StudentManager(){
		initialize();
	}
	
	public void initialize(){
		// initialize the manager
		students=new ArrayList<Student>();
		// load data
		loadStudents();
	}
	
	public void loadStudents(){
		// retrieve courses from file
		ArrayList<Student> ls = retrieveStudents();
		if (ls==null) return;
		for (Object o:ls){
			students.add((Student)o);
		}
	}
	
	public ArrayList<Student> getStudents(){
		return students;
	}
	
	public boolean addStudent(String newStudentName){
		students.add(new Student(newStudentName));
		return true;
	}

	public void storeStudent() {
		// TODO Auto-generated method stub
		StorageManager StMgr=new StorageManager(new SystemConfig());
		StMgr.store("Student",students);
	}
	
	private ArrayList<Student> retrieveStudents(){
		StorageManager StMgr=new StorageManager(new SystemConfig());
		try{
			ArrayList<Student> ls = (ArrayList<Student>) StMgr.read("Student");
			return ls;
		}
		catch (Exception e){
			e.printStackTrace();
			return null;
		}
		
	}

	public Student getCurrentStudent() {
		return currentStudent;
	}
}
