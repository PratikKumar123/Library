package com.lms.library;

public class InvalidChoiceException extends RuntimeException {

	@Override
	public String toString() {
		
		return "Please choose a correct number between 1 to 6 for further process:";
	}
	
}
