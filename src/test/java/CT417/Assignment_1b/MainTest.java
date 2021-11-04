package CT417.Assignment_1b;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import CT417.Assignment_1.Student;

public class MainTest {

	@Test
	public void testModulePrint() {
		Main main = new Main();
		List<Student> students = main.createStudents();
		assertNotEquals(null , students);
	}

}
