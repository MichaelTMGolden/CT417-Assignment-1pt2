package CT417.Assignment_1b;

import java.util.ArrayList;
import java.util.List;

import CT417.Assignment_1.Course;
import CT417.Assignment_1.Module;
import CT417.Assignment_1.Student;

public class SystemPrinter {
	
	public void printCourse(Course course) {
		List<Module> modules =  course.getModulesNames();
		
		List<String> modulesNames = new ArrayList<String>();
		
		for (int i = 0; i < modules.size(); i++) {
			modulesNames.add(modules.get(i).getName());
		}
		
		String coursesAndModule = "Courses and Modules:" + course.getCourseName() + " " + modulesNames+ "\n";
		
		System.out.println(coursesAndModule);
	}

	public void printStudents(Student student) {
		System.out.println(
				"Name: "
				+student.getName() 
				+ "\nUsername: "
				+ student.getUsername()
				+ "\nCourse: "
				+ student.getCourses()
				+ "\nModules: "
				+ student.getModules()
				+ "\n"
				);
	}
}
