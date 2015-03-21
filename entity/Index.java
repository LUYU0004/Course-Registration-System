package entity;

import java.io.Serializable;
import java.util.ArrayList;

public class Index implements Serializable{
	private int id;
	private int vacancy;
	private Course course;
	private ArrayList<Session> sessions;
}
