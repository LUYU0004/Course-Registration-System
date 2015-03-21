package entity;

import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable{
	private String name;
	private int id;
	private ArrayList<Index> registeredIndices;
	private ArrayList<Mark> markRecords;
	
	public Student(String n){
		name=n;
		id=generateId();
	}
	
	/**
	 * to generate a random but unique id for student
	 * @return
	 */
	public int generateId(){
		return 1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
