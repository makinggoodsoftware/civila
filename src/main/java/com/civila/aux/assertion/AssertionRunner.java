package com.civila.aux.assertion;

public class AssertionRunner {
	public AssertResult run(Assertion assertion) {
		if (assertion.condition()){
			return new AssertResult(true, "");
		}else{
			return new AssertResult(false, assertion.assertionErrorDescription());
		}
	}
}
