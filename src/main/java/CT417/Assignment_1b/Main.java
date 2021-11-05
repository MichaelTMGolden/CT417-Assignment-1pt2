package CT417.Assignment_1b;

import java.util.List;
import java.util.ListIterator;

import CT417.Assignment_1.Student;
import CT417.Assignment_1.Module;
import CT417.Assignment_1.Course;

public class Main {
	
	public static void main(String[] args) {
		//Initializes CreateStudent Class
		CreateStudent students = new CreateStudent();
		//Calls createStudents Method and returns a list of student objects
		List<Student> studentsList = students.createStudents();
		
		//Initializes CreateModules Class
		CreateModules modules = new CreateModules();
		//Calls createModule Method and returns a list of Module objects
		List<Module> modulesList = modules.createModule(studentsList);
		
		//Initializes CreateCourses Class
		CreateCourses courses = new CreateCourses();
		//Calls createCourse Method and returns a list of Course objects
		List<Course> courseList = courses.createCourse(studentsList, modulesList);
		
		//Initializes SystemPrinter Class
		SystemPrinter printer = new SystemPrinter();
		
		//Iterates over Course list
		ListIterator<Course> courseListIterator = courseList.listIterator();
		while(courseListIterator.hasNext()){
			//Send Course objects to printer
			Course course = courseListIterator.next();
			printer.printCourse(course);
		}
		
		//Iterates over Student list
		ListIterator<Student> studentsListIterator = studentsList.listIterator();
		while(studentsListIterator.hasNext()){
			//Send Student objects to printer
			Student student = studentsListIterator.next();
			printer.printStudents(student);
		}

	}

}
