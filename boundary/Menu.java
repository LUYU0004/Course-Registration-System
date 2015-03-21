package boundary;

import java.util.ArrayList;
import java.util.Scanner;

import control.CourseManager;
import entity.Course;

public class Menu {
	private static final int GO_BACK=0;
	private static final int GO_BACK_TO_ROOT=-1;
	public static CourseManager courseManager=new CourseManager();
	
	
	public static void main(String [] args){
		System.out.println("Welcome to SCRAME system");
		System.out.println("Enter 0 to go back, and -1 to go back to main menu");
		Scanner s=new Scanner(System.in);
		int choice;
		MenuNodeValue rootItem=MenuNodeValue.APP_ROOT;
		MenuNodeValue currentMenuItem=rootItem;
		ArrayList<MenuNodeValue> childrenList=new ArrayList<MenuNodeValue>();
		
		while(currentMenuItem!=null){
			childrenList=currentMenuItem.getChildren();
			for (int i=0;i<childrenList.size();i++){
				MenuNodeValue childItem=childrenList.get(i);
				System.out.printf("%d. %s\n",(i+1),childItem.description());
			}
			
			System.out.println("Enter your choice=>");
			
			try{
				choice=s.nextInt();
				// check the validity of the choice
				if (choice<=childrenList.size() && choice>=GO_BACK_TO_ROOT){
					// choice is valid
					// first check whether it's going back
					if (choice==GO_BACK){
						if (currentMenuItem.parent()!=null)
							currentMenuItem=currentMenuItem.parent();
						else
							System.out.println("Cannot go back");
					}
					else if (choice==GO_BACK_TO_ROOT){
						currentMenuItem=rootItem;
					}
					else{
						// if not going back, execute normally
						MenuNodeValue selectedItem=childrenList.get(choice-1);
						if (selectedItem.isLeaf()){
							executeChoice(selectedItem);
						}
						else{
							// first display subitems
							if (executeChoice(selectedItem)){
								currentMenuItem=selectedItem;
							}
						}
					}
				}
				else{
					throw new Exception("Invalid choice");
				}
			}
			catch(java.util.InputMismatchException e1){
				System.out.println("Invalid Choice!");
				s.nextLine();
			}
			catch(Exception e2){
				System.out.println(e2.getMessage());
			}
			System.out.println("==============================");
		}

		
	}
	
	
	/**
	 * the return value is to indicate whether the execution is considered successful
	 * @param chosenItem
	 * @return boolean
	 */
	public static boolean executeChoice(MenuNodeValue chosenItem){
		if (chosenItem.equals(MenuNodeValue.COURSE_LIST)){
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
		else if (chosenItem.equals(MenuNodeValue.COURSE_ADD)){
			Scanner s=new Scanner(System.in);
			System.out.println("Enter course code:");
			String courseCode=s.nextLine();
			if (courseManager.addCourse(courseCode)){
				System.out.println("Course " + courseCode + "is added successfully");
			}
			else{
				System.out.println("Fail to add course " + courseCode);
			}
		}
		else if (chosenItem.equals(MenuNodeValue.SAVE_EXIT)){
			courseManager.storeCourses();
			System.out.println("Courses saved");
			System.exit(0);
		}
		else if (chosenItem.equals(MenuNodeValue.COURSE_EDIT)){
			System.out.println("Enter a course code:");
			Scanner sc=new Scanner(System.in);
			String courseCode=sc.nextLine();
			if (courseManager.setCurrentCourse(courseCode)){
				System.out.println("Editing course " + courseCode);
			}
			else{
				System.out.println("The course code is not found");
				return false;
			}
		}
		else if (chosenItem.equals(MenuNodeValue.COURSE_ADD_SESSION)){
			System.out.println("Enter session type:");
			Scanner sc=new Scanner(System.in);
			int type=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter session group id:");
			String groupId=sc.nextLine();
			courseManager.addSessionToCurrentCourse(type, groupId);
			System.out.println("Session added");
		}
		else if (chosenItem.equals(MenuNodeValue.COURSE_LIST_SESSION)){
			System.out.println(courseManager.getSessionInfo());
		}
		else{
			System.out.println("Executed");
		}
		
		return true;
		
	}
}
