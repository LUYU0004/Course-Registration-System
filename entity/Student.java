package entity;

import java.io.PrintStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import control.StudentManager;
import control.StudentManager;

/**
 * 
 * @author DU QIU
 *
 */

public class Student implements Serializable{
	private String name;
	private String matriNo;
	private ArrayList<Index> registeredIndices;
	private ArrayList<Mark> markRecords;
	/**
	 * to construct a student object with student name
	 * @param name
	 */
	
	public Student(String name){
		this.name = name;
		matriNo = generateMatricNo();
	}
	
	/**
	 * to generate a unique id for student
	 * @return
	 */
	public String generateMatricNo(){
		
		Calendar cd = Calendar.getInstance();
		int year = cd.get(Calendar.YEAR)%100;
		
		StudentManager sm = new StudentManager();
		int num = sm.getStudents().size();
		
		char start = (char)85;
		char end = (char)65;
		
		if(num/100000!=0){
			if(num/100000<(90-65))
				end = (char)(65+num/100000);
		}
		
		int index = num % 100000;
		String result;
		result = String.format("%c%2d%05d%c", start,year,index,end);
		return  result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMatricNo() {
		return matriNo;
	}

	public void setMatricNo(String matricNo) {
		this.matriNo = matricNo;
	}

	public ArrayList<Index> getRegisteredIndices() {
		return registeredIndices;
	}

	public void setRegisteredIndices(ArrayList<Index> registeredIndices) {
		this.registeredIndices = registeredIndices;
	}

	public ArrayList<Mark> getMarkRecords() {
		return markRecords;
	}

	public void setMarkRecords(ArrayList<Mark> markRecords) {
		this.markRecords = markRecords;
	}
}
