package control;

import java.util.ArrayList;

import entity.Course;
import entity.Student;

public class StudentManager {
	private ArrayList<Student> students;
	
	public StudentManager(){
		initialize();
	}
	
	public void initialize(){
		// initialize the manager
		students=new ArrayList<Student>();
		// load data
		Student c1=new Student("z");
		Student c2=new Student("a");
		Student c3=new Student("b");
		students.add(c1);
		students.add(c2);
		students.add(c3);
		
	}
	
	public void loadStudents(){
		// retrieve courses from file
	}
	
	public ArrayList<Student> getStudents(){
		return students;
	}
	
	public boolean addStudent(String newStudentName){
		students.add(new Student(newStudentName));
		return true;
	}
}
