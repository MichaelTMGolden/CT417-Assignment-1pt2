package CT417.Assignment_1b;

import java.util.ArrayList;
import java.util.List;

import CT417.Assignment_1.Student;

public class CreateStudent {
	
	public List<Student> createStudents() {
		
		DateParser dateParser = new DateParser();
		
		//Creates a list of modules and adds to list
		List<String> modules1 = List.of("CT412", "CT413", "CT432", "CT4412", "CT512");
		List<String> modules2 = List.of("CT412", "CT413", "CT432", "CT4412", "CT512");
		List<String> modules3 = List.of("SE3432", "CT413", "CT432", "CT4412", "CT512");
		List<String> modules4 = List.of("SE3432", "SE905", "SE546", "CT4412", "CT512");
		List<String> modules5 = List.of("TE3572", "TE201", "TE32", "CT4412", "CT512");
		
		List<Student> studentsList = new ArrayList<Student>();
		
		//Creates a list of students and adds to list
		Student student1 = new Student("Celsus", dateParser.parseDate("12/03/1998"), "535659", "Computing Technology", modules1);
		Student student2 = new Student("Callie", dateParser.parseDate("02/04/1997"), "342354", "Computing Technology", modules2);
		Student student3 = new Student("Makarios", dateParser.parseDate("10/11/1996"), "183367", "Computing Technology", modules3);
		Student student4 = new Student("Dorotheus", dateParser.parseDate("23/05/1998"), "250084", "Software Engineering", modules4);
		Student student5 = new Student("Haraldr", dateParser.parseDate("30/04/1997"), "717640", "Technology Engineering", modules5);

		studentsList.add(student1);
		studentsList.add(student2);
		studentsList.add(student3);
		studentsList.add(student4);
		studentsList.add(student5);
		
		return studentsList;
	}

}
