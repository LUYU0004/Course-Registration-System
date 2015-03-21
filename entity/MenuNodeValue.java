package entity;

import java.util.ArrayList;

public enum MenuNodeValue {
	APP_ROOT(0,"Main Menu"),
	COURSE_ROOT(1,APP_ROOT,"Course Module Main Menu"),
	STUDENT_ROOT(1,APP_ROOT,"Student Module Main Menu"),
	EXIT(1,APP_ROOT,"Exit"),
	
	STUDENT_LIST(2,STUDENT_ROOT,"List Student"),
	STUDENT_ADD(2,STUDENT_ROOT,"Add Student"),
	STUDENT_EDIT(2,STUDENT_ROOT,"Edit Student"),
	STUDENT_TRANSCRIPT(3,STUDENT_EDIT,"Print Student Transcript"),
	STUDENT_CHECKCOURSE(3,STUDENT_EDIT,"Check course registered"),
	
	COURSE_LIST(2,COURSE_ROOT,"List courses"),
	COURSE_ADD(2,COURSE_ROOT,"Add a new course"),
	COURSE_EDIT(2,COURSE_ROOT,"Edit a course"),
	COURSE_REGISTER(2,COURSE_EDIT,"Register a student"),
	COURSE_CHECK_VACANCY(2,COURSE_EDIT,"Check vacancy"),
	COURSE_PRINTLIST(2,COURSE_EDIT,"Print student list"),
	COURSE_ENTER_WEIGHTAGE(2,COURSE_EDIT,"Enter assessment weightage"),
	COURSE_ENTER_COURSEWORK_MARK(2,COURSE_EDIT,"Enter course work mark for students"),
	COURSE_ENTER_EXAM_MARK(2,COURSE_EDIT,"Enter exam mark for students"),
	COURSE_SHOW_STATISTICS(2,COURSE_EDIT,"Show course statistics"),
	COURSE_ADD_SESSION(2,COURSE_EDIT,"Add session"),
	COURSE_LIST_SESSION(2,COURSE_EDIT,"List sessions"),
	
	COURSE_PRINTLIST_LAB(2,COURSE_PRINTLIST,"Print according to lab"),
	COURSE_PRINTLIST_LECTURE(2,COURSE_PRINTLIST,"Print according to lecture"),
	COURSE_PRINTLIST_TUTORIAL(2,COURSE_PRINTLIST,"Print according to tutorial"),
	;
	
	private final int value;
	private final MenuNodeValue parent;
	private final String desc;
	
	MenuNodeValue(int v,String s){
		value=v;
		desc=s;
		parent=null;
	}
	
	MenuNodeValue(int v,MenuNodeValue p,String s){
		value=v;
		desc=s;
		parent=p;
	}
	
	public int value(){
		return value;
	}
	
	public String description(){
		return desc;
	}
	
	public MenuNodeValue parent(){
		return parent;
	}
	
	public ArrayList<MenuNodeValue> getChildren(){
		ArrayList<MenuNodeValue> childrenList=new ArrayList<MenuNodeValue>();
		for (MenuNodeValue m:MenuNodeValue.values()){
			if (m.parent()!=null && m.parent().equals(this)){
				childrenList.add(m);
			}
		}
		return childrenList;
	}
	
	public boolean isLeaf(){
		ArrayList<MenuNodeValue> children=this.getChildren();
		if (children.size()==0)
			return true;
		else
			return false;
	}
}
