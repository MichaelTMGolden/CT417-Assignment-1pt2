package CT417.Assignment_1b;

import java.util.ArrayList;
import java.util.List;

import CT417.Assignment_1.Course;
import CT417.Assignment_1.Module;
import CT417.Assignment_1.Student;

public class CreateCourses {
	public List<Course> createCourse(List<Student> studentsList, List<Module> modulesList) {
		//Initalzes DateParse Class
		DateParser dateParser = new DateParser();
		
		List<Course> courseList = new ArrayList<Course>();
		
		//Creates Course Objects
		Course course1 = new Course("Computing Technology" , getCourseStudentList(studentsList, "Computing Technology"), getCourseModuleList(modulesList, "CT"), dateParser.parseDate("01/09/21"), dateParser.parseDate("30/05/22"));
		Course course2 = new Course("Software Engineering", getCourseStudentList(studentsList, "Software Engineering"), getCourseModuleList(modulesList, "SE"), dateParser.parseDate("03/09/21"), dateParser.parseDate("21/05/22"));
		Course course3 = new Course("Technology Engineering", getCourseStudentList(studentsList, "Technology Engineering"), getCourseModuleList(modulesList, "TE"), dateParser.parseDate("05/09/21"), dateParser.parseDate("27/05/22"));
		
		//Adds course objects to list
		courseList.add(course1);
		courseList.add(course2);
		courseList.add(course3);
		
		return courseList;
	}
	
	public List<Student> getCourseStudentList(List<Student> studentsList, String courseName) {
		
		List<Student> studentsInCourseList = new ArrayList<Student>();
		
		//Iterates through Student list and checks to see if they are assigned to this course
		for (int i = 0; i < studentsList.size(); i++) {
			Student student = studentsList.get(i);
			if (student.getCourses() == courseName) {
				studentsInCourseList.add(student);
			}
			else {
				continue;
			}
		}
		return studentsInCourseList;
	}
	
	private List<Module> getCourseModuleList(List<Module> modulesList, String courseId) {
		
		List<Module> courseModulesList = new ArrayList<Module>();
		
		//Iterates through Module list and checks to see if they are assigned to this course
		for (int i = 0; i < modulesList.size(); i++) {
			Module module = modulesList.get(i);
			String[] arr = module.id.split("\\d+", 2);
			String code = arr[0].trim();
			if(code.equals(courseId)) {
				courseModulesList.add(module);
			}
			else {
				continue;
			}
		}
		return courseModulesList;
	}
	
}
