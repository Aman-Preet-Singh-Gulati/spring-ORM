package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
    	StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
    	
		/*
		 * Student student = new Student(1234, "Aman Preet Singh Gulati", "Kanpur"); 
		 * int result = studentDao.insert(student); 
		 * System.out.println("Done:" +result);
		 */
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	boolean go = true;
    	while (go)
    	{
    		System.out.println("PRESS 1 for Adding a new student");
        	System.out.println("PRESS 2 for Displaying all students");
        	System.out.println("PRESS 3 for Displaying specific student");
        	System.out.println("PRESS 4 for Deleting a student");
        	System.out.println("PRESS 5 for Updating a student");
        	System.out.println("PRESS 6 for Exit");
        	
        	try {
        		
        		int choice = Integer.parseInt(br.readLine());
        		
        		switch (choice) {
				case 1:
					// Adding a new student
					System.out.println("Enter student's Id: ");
					int studentId = Integer.parseInt(br.readLine());
					
					System.out.println("Enter student's Name: ");
					String name = br.readLine();
					
					System.out.println("Enter student's City: ");
					String city = br.readLine();
					
					Student s = new Student();
					s.setStudentCity(city);
					s.setStudentId(studentId);
					s.setStudentName(name);
					 	
					// Saving student object to database by calling insert function from StudentDao.
					int result = studentDao.insert(s);
					System.out.println(result + " Student added");
					System.out.println("****************************************************");
					

					break;
				case 2:
					// Displaying all students
					
					List<Student> allStudents = studentDao.getAllStudents();
					for (Student st:allStudents)
					{
						System.out.println("Name: "+st.getStudentName());
						System.out.println("City: "+st.getStudentCity());
						System.out.println("ID: "+st.getStudentId());
					}
					System.out.println("****************************************************");

					break;
				case 3:
					// Displaying specific student
					System.out.println("Enter student's Id: ");
					int studentIdDisp = Integer.parseInt(br.readLine());
					Student student = studentDao.getStudent(studentIdDisp);
					
					System.out.println("Name: "+student.getStudentName());
					System.out.println("City: "+student.getStudentCity());
					System.out.println("ID: "+student.getStudentId());
					
					System.out.println("****************************************************");

					break;
				case 4:
					// Deleting a student
					System.out.println("Enter student's Id: ");
					int studentIdDlt = Integer.parseInt(br.readLine());
					studentDao.deleteStudent(studentIdDlt);
					System.out.println(studentIdDlt+ " Deleted..");
					break;
				case 5:
					// Updating a student
					System.out.println("Enter student's Id: ");
					int studentIdUpd = Integer.parseInt(br.readLine());
//					studentDao.updateStudent(s);
					
					break;	
				case 6:
					// Exit
					System.out.println("Thankyou for using this application");
					System.out.println("****************************************************");
					go = false;
					break;
				
				default:
					break;
				}
				
			} catch (Exception e) {
				System.out.println("Invalid input, try again!..");
				System.out.println(e.getMessage());
			}
    	}
    }
}
