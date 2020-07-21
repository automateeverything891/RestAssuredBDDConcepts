package com.Rest.Utils;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {

	
	public static String empName() {
		String generatedString=RandomStringUtils.randomAlphabetic(3);
		return ("Adam "+generatedString);
	}
	
	public static String empSalary() {
		String generatedString=RandomStringUtils.randomNumeric(5);
		return (generatedString);
	}
	
	public static String empAge() {
		String generatedString=RandomStringUtils.randomNumeric(2);
		return (generatedString);
	}
	public static String empJob() {
		String generatedString=RandomStringUtils.randomAlphabetic(2);
		return ("Leader"+generatedString);
	}
	public static String email() {
		String generatedString=RandomStringUtils.randomAlphabetic(2);
		return ("Leader"+generatedString+"@gmail.com");
	}
	
}
