package CT417.Assignment_1b;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

import CT417.Assignment_1.Student;

public class MainTest {

	@Test
	public void testModulePrint() {
		Main main = new Main();
		
		List<String> modules = List.of("CT412", "CT413", "CT432", "CT4412", "CT512");
		
		String dateTime = "12/03/1998";
		
		DateTimeFormatter dtf = DateTimeFormat.forPattern("dd/MM/yyyy");
		
		DateTime dob = dtf.parseDateTime(dateTime);
		
		Student student = new Student("Celsus", dob, "535659", "Computing Technology", modules);
		
		List<Student> studentList = new ArrayList<Student>();
		
		assertEquals(studentList , main.getCourseStudentList(studentList, "Computing Technology"));
	}

}
