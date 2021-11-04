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
		
		ListIterator<Student> studentsListIterator = studentsList.listIterator();
		while(studentsListIterator.hasNext()){
			Student student = studentsListIterator.next();
			printStudents(student);
		}
		
		ListIterator<Module> moduleListIterator = modulesList.listIterator();
		while(moduleListIterator.hasNext()){
			Module module = moduleListIterator.next();
			printModule(module);
		}
		
		ListIterator<Course> courseListIterator = courseList.listIterator();
		while(courseListIterator.hasNext()){
			Course course = courseListIterator.next();
			printCourse(course);
		}

	}
	
	private static void printCourse(Course course) {
		System.out.println(
				 course.getCourseName()
				+ " "
				+ course.getStudentsNames()
				+ " "
				+ course.getModulesNames()
				+ " "
				+ course.getStartDate()
				+ " "
				+ course.getEndDate()
				+ "\n"
				);
	}

	private static void printModule(Module module) {
		System.out.println(
				 module.getName()
				+ " "
				+ module.getId()
				+ " "
				+ module.getStudentsNames()
				+ " "
				+ module.getCourses()
				+ "\n"
				);
	}

	

	private static void printStudents(Student student) {
		System.out.println(
				student.getName() 
				+ " "
				+ student.getAge()
				+ " "
				+ student.getDob()
				+ " "
				+ student.getId()
				+ " "
				+ student.getUsername()
				+ " "
				+ student.getCourses()
				+ " "
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

	private static List<Student> getCourseStudentList(List<Student> studentsList, String string) {
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
			List<String> courses = module.getCourses();
			if(courses.contains(courseId)) {
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
		String[] names = {
				"Celsus",
				"Callie",
				"Makarios",
				"Dorotheus",
				"Haraldr"
				};
		
		
		DateTime[] dobs = {
				parseDate("12/03/1998"), 
				parseDate("02/04/1997"),
				parseDate("10/11/1996"),
				parseDate("23/05/1998"),
				parseDate("30/04/1997")
				};
		
		String[] ids = {
				"535659",
				"342354",
				"183367",
				"250084",
				"717640"
				};
		
		String[] courses = {
			"Computing Technology",
			"Computing Technology",
			"Computing Technology",
			"Software Engineering",
			"Technology Engineering"
		};
		
		List<List<String>> listOfModuleLists = new ArrayList<List<String>>();
		
		List<String> modules1 = List.of("CT412", "CT413", "CT432", "CT4412", "CT512");
		List<String> modules2 = List.of("CT412", "CT413", "CT432", "CT4412", "CT512");
		List<String> modules3 = List.of("SE3432", "CT413", "CT432", "CT4412", "CT512");
		List<String> modules4 = List.of("SE3432", "SE905", "SE546", "CT4412", "CT512");
		List<String> modules5 = List.of("TE3572", "TE201", "TE32", "CT4412", "CT512");
		
		listOfModuleLists.add(modules1);
		listOfModuleLists.add(modules2);
		listOfModuleLists.add(modules3);
		listOfModuleLists.add(modules4);
		listOfModuleLists.add(modules5);
	
		
		List<Student> studentsList = new ArrayList<Student>();
		
		for (int i = 0 ; i < 5; i++) {
			Student student = new Student(names[i], dobs[i], ids[i], courses[i], listOfModuleLists.get(i));
			studentsList.add(student);
		}
		return studentsList;
	}
	
	private static DateTime parseDate(String dob) {
		
		DateTimeFormatter dtf = DateTimeFormat.forPattern("dd/MM/yyyy");
		
		return dtf.parseDateTime(dob);
	}

}
