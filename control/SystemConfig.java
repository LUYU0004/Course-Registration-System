package control;


import java.util.HashMap;
import java.util.Map;

public class SystemConfig {
	// Store <name, value> pairs of system configuration
	private Map<String, String> configs = new HashMap<String, String>();

	public String get(String name) {
		return configs.get(name);
	}
	
	public SystemConfig(){
		configs.put("StorageMethod", "Serialize");
		configs.put("Course", "Course.txt");
		configs.put("Student", "Student.txt");
		configs.put("Enroll", "Enroll.txt");
	}
}
