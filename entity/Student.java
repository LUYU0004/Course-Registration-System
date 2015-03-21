package entity;

import java.io.Serializable;
import java.util.ArrayList;

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
	 * to generate a random but unique id for student
	 * @return
	 */
	public String generateMatricNo(){
		return "G0000";
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
