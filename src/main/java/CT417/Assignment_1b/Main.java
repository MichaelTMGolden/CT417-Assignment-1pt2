package CT417.Assignment_1b;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import CT417.Assignment_1.Student;
import CT417.Assignment_1.Module;
import CT417.Assignment_1.Course;

public class Main {
	
	public static void main(String[] args) {
		List<Student> studentsList = createStudents();
		List<Module> modulesList = createModule(studentsList);
		List<Course> courseList = createCourse(studentsList, modulesList);
		
		ListIterator<Course> courseListIterator = courseList.listIterator();
		while(courseListIterator.hasNext()){
			Course course = courseListIterator.next();
			printCourse(course);
		}
		
		ListIterator<Student> studentsListIterator = studentsList.listIterator();
		while(studentsListIterator.hasNext()){
			Student student = studentsListIterator.next();
			printStudents(student);
		}

	}
	
	private static void printCourse(Course course) {
		List<Module> modules =  course.getModulesNames();
		
		List<String> modulesNames = new ArrayList<String>();
		
		for (int i = 0; i < modules.size(); i++) {
			modulesNames.add(modules.get(i).getName());
		}
		
		String coursesAndModule = "Courses and Modules:" + course.getCourseName() + " " + modulesNames+ "\n";
		
		System.out.println(coursesAndModule);
	}

	static void printStudents(Student student) {
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

	private static List<Course> createCourse(List<Student> studentsList, List<Module> modulesList) {
		
		List<Course> courseList = new ArrayList<Course>();

		Course course1 = new Course("Computing Technology" , getCourseStudentList(studentsList, "Computing Technology"), getCourseModuleList(modulesList, "CT"), parseDate("01/09/21"), parseDate("30/05/22"));
		Course course2 = new Course("Software Engineering", getCourseStudentList(studentsList, "Software Engineering"), getCourseModuleList(modulesList, "SE"), parseDate("03/09/21"), parseDate("21/05/22"));
		Course course3 = new Course("Technology Engineering", getCourseStudentList(studentsList, "Technology Engineering"), getCourseModuleList(modulesList, "TE"), parseDate("05/09/21"), parseDate("27/05/22"));
		
		courseList.add(course1);
		courseList.add(course2);
		courseList.add(course3);
		
		return courseList;
	}

	static List<Student> getCourseStudentList(List<Student> studentsList, String string) {
		
		List<Student> studentsInCourseList = new ArrayList<Student>();
		
		for (int i = 0; i < studentsList.size(); i++) {
			Student student = studentsList.get(i);
			if (student.getCourses() == string) {
				studentsInCourseList.add(student);
			}
			else {
				continue;
			}
		}
		return studentsInCourseList;
	}

	private static List<Module> getCourseModuleList(List<Module> modulesList, String courseId) {
		
		List<Module> courseModulesList = new ArrayList<Module>();
		
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

	private static List<Module> createModule(List<Student> studentsList) {
		
		List<Module> modulesList = new ArrayList<Module>();
		
		List<String> courseList = List.of("Computing Technology", "Software Engineering", "Technology Engineering");
		
		Module module1 = new Module("Comps" , "SE3432", getModuleStudentList(studentsList, "SE3432"), courseList);
		Module module2 = new Module("Technology" , "CT412", getModuleStudentList(studentsList, "CT412"), courseList);
		Module module3 = new Module("Information" , "TE3572", getModuleStudentList(studentsList, "TE3572"), courseList);
		Module module4 = new Module("Software" , "CT512", getModuleStudentList(studentsList, "CT512"), courseList);
		Module module5 = new Module("Cables" , "SE546", getModuleStudentList(studentsList, "SE546"), courseList);
		
		modulesList.add(module1);
		modulesList.add(module2);
		modulesList.add(module3);
		modulesList.add(module4);
		modulesList.add(module5);
		
		return modulesList;
	}

	private static List<Student> getModuleStudentList(List<Student> studentsList, String course) {
		
		List<Student> presentStudentsList = new ArrayList<Student>();
		
		for (int i = 0; i < studentsList.size(); i++) {
			Student student = studentsList.get(i);
			List<String> modules = student.getModules();
			if(modules.contains(course)){
				presentStudentsList.add(student);
			}else {
				continue;
			}
		}
		return presentStudentsList;
	}

	static List<Student> createStudents() {
		
		List<String> modules1 = List.of("CT412", "CT413", "CT432", "CT4412", "CT512");
		List<String> modules2 = List.of("CT412", "CT413", "CT432", "CT4412", "CT512");
		List<String> modules3 = List.of("SE3432", "CT413", "CT432", "CT4412", "CT512");
		List<String> modules4 = List.of("SE3432", "SE905", "SE546", "CT4412", "CT512");
		List<String> modules5 = List.of("TE3572", "TE201", "TE32", "CT4412", "CT512");
		
		List<Student> studentsList = new ArrayList<Student>();
		
		Student student1 = new Student("Celsus", parseDate("12/03/1998"), "535659", "Computing Technology", modules1);
		Student student2 = new Student("Callie", parseDate("02/04/1997"), "342354", "Computing Technology", modules2);
		Student student3 = new Student("Makarios", parseDate("10/11/1996"), "183367", "Computing Technology", modules3);
		Student student4 = new Student("Dorotheus", parseDate("23/05/1998"), "250084", "Software Engineering", modules4);
		Student student5 = new Student("Haraldr", parseDate("30/04/1997"), "717640", "Technology Engineering", modules5);

		studentsList.add(student1);
		studentsList.add(student2);
		studentsList.add(student3);
		studentsList.add(student4);
		studentsList.add(student5);
		
		return studentsList;
	}
	
	private static DateTime parseDate(String dob) {
		
		DateTimeFormatter dtf = DateTimeFormat.forPattern("dd/MM/yyyy");
		
		return dtf.parseDateTime(dob);
	}

}
