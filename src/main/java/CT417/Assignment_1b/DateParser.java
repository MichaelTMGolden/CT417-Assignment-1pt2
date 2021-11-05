package CT417.Assignment_1b;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateParser {
	public DateTime parseDate(String dob) {
		//Parses and formats date to DateTime object
		DateTimeFormatter dtf = DateTimeFormat.forPattern("dd/MM/yyyy");
		
		return dtf.parseDateTime(dob);
	}
}
