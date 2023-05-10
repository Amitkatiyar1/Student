package com.example.Curd.Exception;

public class EmployeeException extends Exception {
	private static final long serialVersionUID = 1L;

	public EmployeeException(String message) {
		super(message);

	}

	public static String NotFoundException(Integer id) {
		return "Student with" + id + "not found";
	}

	public static String NotFoundException(String id) {
		return "Student with" + id + "not found";
	}
}
