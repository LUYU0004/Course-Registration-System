package control;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import entity.Course;
import entity.MenuNodeValue;
import entity.Student;

/**
 * 
 * @author DU QIU
 *
 */

public class MenuManager {
	
	private final int GO_BACK=0;
	private final int GO_BACK_TO_ROOT=-1;
	private MenuNodeValue currentMenuItem;
	private static CourseManager courseManager = new CourseManager();
	private static StudentManager studentManager = new StudentManager();
	private static PrinterManager printerManager = new PrinterManager();
	
	public void displayMenu() {
		System.out.println("****************************");
		System.out.println("* Welcome to SCRAME system *");
		System.out.println("****************************");
		Scanner sc = new Scanner(System.in);
		int choice;
		MenuNodeValue rootItem = MenuNodeValue.APP_ROOT;
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
				choice=sc.nextInt();
				
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
				sc.nextLine();
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
		case COURSE_REGISTER: registerCourse();
			break;
		case COURSE_CHECK_VACANCY: checkCourseVacancy();
			break;
		case COURSE_PRINTLIST: printCourseList();
			break;
		case COURSE_ENTER_WEIGHTAGE: enterAssignmentWeightage();
			break;
		case COURSE_ENTER_COURSEWORK_MARK: enterCourseworkMark();
			break;
		case COURSE_ENTER_EXAM_MARK: enterExamMark();
			break;
		case COURSE_SHOW_STATISTICS: showCourseStatistics();
			break;
		case COURSE_ADD_SESSION: addSession();
			break;
		case COURSE_LIST_SESSION: System.out.println(courseManager.getSessionInfo());
			break;
		case STUDENT_ADD: addStudent();
			break;
		case STUDENT_LIST: printStudentList();
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

	private void enterExamMark() {
		// TODO Auto-generated method stub
		
	}

	private void enterCourseworkMark() {
		// TODO Auto-generated method stub
		
	}

	private void enterAssignmentWeightage() {
		// TODO Auto-generated method stub
		
	}

	private void printCourseList() {
		// TODO Auto-generated method stub
		
	}

	private void checkCourseVacancy() {
		// TODO Auto-generated method stub
		
	}

	private void registerCourse() {
		// TODO Auto-generated method stub
		
	}

	private void showCourseStatistics() {
		// TODO Auto-generated method stub
		
	}

	private void printStudentTranscript() {
		// TODO Auto-generated method stub
		
	}

	private void checkRegisteredCourse() {
		// TODO Auto-generated method stub
		
	}

	private void printStudentList() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Print Student List By:");
		System.out.println("1. Lecture Session");
		System.out.println("2. Tutorial Session");
		System.out.println("3. Laboratory Session");
		int choice = 0;
		try{
			choice = sc.nextInt();
			if (choice<=0&&choice>=4) 
				throw new Exception("Invalid Option");
		}catch(InputMismatchException e){
			e.getMessage();
			sc.nextLine();
		}catch(Exception e){
			e.getMessage();
		}
		
		String type;
		
		switch(choice){
		case 1: type = "Lecture";
			break;
		case 2: type = "Tutorial";
			break;
		case 3: type = "Laboratory";
			break;
		case 4: System.out.println("Invalid Option");
		}
		printerManager.printStudentListBy();
	}


	private void addStudent() {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter student name:");
		String name=s.nextLine();
		if (studentManager.addStudent(name)){
			studentManager.storeStudent();
			System.out.println("Student " + name + " is added successfully");
		}
		else{
			System.out.println("Fail to add student " + name);
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
