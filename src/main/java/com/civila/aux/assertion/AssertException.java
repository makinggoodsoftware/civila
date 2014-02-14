package com.civila.aux.assertion;

public class AssertException extends Exception {
	public AssertException(String description, AssertException cause) {
		super(description, cause);
	}

	public AssertException(String errorDesc) {
		super(errorDesc);
	}
}
