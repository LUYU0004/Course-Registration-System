package control;

import java.util.ArrayList;

import entity.Student;

/**
 * 
 * @author DU QIU
 *
 */
public class PrinterManager {

	public void printStudentListBy() {

		System.out.println("Student Listing:");
		
		ArrayList<Student> student= (new StudentManager()).getStudents();
		if (student.size()==0){
			System.out.println("No student currently");
		}else{
			for (Student s:student){
				System.out.println(s.getMatricNo()+" "+s.getName());
			}
		}
	}

}
