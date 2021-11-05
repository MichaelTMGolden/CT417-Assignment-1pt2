package CT417.Assignment_1b;

import java.util.ArrayList;
import java.util.List;

import CT417.Assignment_1.Module;
import CT417.Assignment_1.Student;

public class CreateModules {
	public List<Module> createModule(List<Student> studentsList) {
		
		List<Module> modulesList = new ArrayList<Module>();
		
		List<String> courseList = List.of("Computing Technology", "Software Engineering", "Technology Engineering");
		
		//Creates Module objects and adds them to a list
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
	
	private List<Student> getModuleStudentList(List<Student> studentsList, String module) {
		
		List<Student> presentStudentsList = new ArrayList<Student>();
		
		//Iterates through student list and checks to see if they assigned to module
		for (int i = 0; i < studentsList.size(); i++) {
			Student student = studentsList.get(i);
			List<String> modules = student.getModules();
			if(modules.contains(module)){
				presentStudentsList.add(student);
			}else {
				continue;
			}
		}
		return presentStudentsList;
	}

}
