package com.civila.aux.assertion;

public class AssertException extends RuntimeException {
	public AssertException(String description, AssertException cause) {
		super(description, cause);
	}

	public AssertException(String errorDesc) {
		super(errorDesc);
	}

	public AssertException(AssertException cause) {
		super(cause);
	}
}
