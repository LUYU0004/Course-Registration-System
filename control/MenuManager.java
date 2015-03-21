package control;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import entity.Course;
import entity.MenuNodeValue;
import entity.Student;

public class MenuManager {
	
	private final int GO_BACK=0;
	private final int GO_BACK_TO_ROOT=-1;
	private MenuNodeValue currentMenuItem;
	private static CourseManager courseManager = new CourseManager();
	private static StudentManager studentManager = new StudentManager();
	
	public void displayMenu() {
		System.out.println("****************************");
		System.out.println("* Welcome to SCRAME system *");
		System.out.println("****************************");
		Scanner s = new Scanner(System.in);
		int choice;
		MenuNodeValue rootItem=MenuNodeValue.APP_ROOT;
		currentMenuItem = rootItem;
		ArrayList<MenuNodeValue> childrenList=new ArrayList<MenuNodeValue>();
		
		while(currentMenuItem!=null){
			childrenList=currentMenuItem.getChildren();
			for (int i=0;i<childrenList.size();i++){
				MenuNodeValue childItem=childrenList.get(i);
				System.out.printf("%d. %s\n",(i+1),childItem.description());
			}
			
			System.out.println("* Enter '0' go back, '-1' main menu *");
			System.out.println("Enter your choice:");
			
			try{
				choice=s.nextInt();
				
				// check the validity of the choice
				if (choice>childrenList.size() || choice<GO_BACK_TO_ROOT)
					throw new Exception("Invalid Choice");
				
				// first check whether it's going back
				if (choice==GO_BACK){
					if (currentMenuItem.parent()!=null)
						currentMenuItem = currentMenuItem.parent();
					else
						System.out.println("Top Menu");
				}else if (choice==GO_BACK_TO_ROOT){
					currentMenuItem = rootItem;
				}else{
					// if not going back, execute normally
					MenuNodeValue selectedItem = childrenList.get(choice-1);
					executeChoice(selectedItem);
				}
			}catch(InputMismatchException e){
				System.out.println("Invalid Choice!");
				s.nextLine();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
			System.out.println("==============================");
		}
	}

	/**
	 * the return value is to indicate whether the execution is considered successful
	 * @param chosenItem
	 * @return boolean
	 */
	private boolean executeChoice(MenuNodeValue chosenItem){
		
		switch(chosenItem){
		
		case COURSE_LIST: listCourse();
			break;
		case COURSE_ADD: addCourse();
			break;
		case COURSE_EDIT: editCourse();
			break;
		case COURSE_ADD_SESSION: addSession();
			break;
		case COURSE_LIST_SESSION: System.out.println(courseManager.getSessionInfo());
			break;
		case STUDENT_ADD: addStudent();
			break;
		case STUDENT_LIST: listStudent();
			break;
		case STUDENT_CHECKCOURSE: checkRegisteredCourse();
			break;
		case STUDENT_TRANSCRIPT: printStudentTranscript();
			break;
		case EXIT: System.exit(0);
			break;
		default: currentMenuItem = chosenItem;
			return false;
		}
		
		return true;
	}

	private void printStudentTranscript() {
		// TODO Auto-generated method stub
		
	}

	private void checkRegisteredCourse() {
		// TODO Auto-generated method stub
		
	}

	private void listStudent() {
		System.out.println("Student Listing:");
		ArrayList<Student> student=studentManager.getStudents();
		if (student.size()==0){
			System.out.println("No student currently");
		}
		else{
			for (Student s:student){
				System.out.println(s.getMatricNo()+" "+s.getName());
			}
		}
	}


	private void addStudent() {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter student name:");
		String name=s.nextLine();
		if (studentManager.addStudent(name)){
			studentManager.storeStudent();
			System.out.println("Course " + name + " is added successfully");
		}
		else{
			System.out.println("Fail to add course " + name);
		}
	}

	private void addSession() {
		System.out.println("Enter session type:");
		Scanner sc=new Scanner(System.in);
		int type=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter session group id:");
		String groupId=sc.nextLine();
		courseManager.addSessionToCurrentCourse(type, groupId);
		System.out.println("Session added");
	}


	private void editCourse() {
		System.out.println("Enter a course code:");
		Scanner sc=new Scanner(System.in);
		String courseCode=sc.nextLine();
		if (courseManager.setCurrentCourse(courseCode)){
			System.out.println("Editing course " + courseCode);
		}
		else{
			System.out.println("The course code is not found");
		}
	}


	private void listCourse() {
		System.out.println("Course Listing:");
		ArrayList<Course> courses=courseManager.getCourses();
		if (courses.size()==0){
			System.out.println("No course currently");
		}
		else{
			for (Course c:courses){
				System.out.println(c);
			}
		}
	}


	private void addCourse() {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter course code:");
		String courseCode=s.nextLine();
		System.out.println("Enter course name:");
		String courseName=s.nextLine();
		if (courseManager.addCourse(courseCode, courseName)){
			System.out.println("Course " + courseCode +" "+courseName + " is added successfully");
			System.out.println("Courses saved");
			courseManager.storeCourses();
		}
		else{
			System.out.println("Fail to add course " + courseCode);
		}
	}
}
