package com.civila.aux.assertion;

public class AssertResult {
	private final boolean successful;

	public AssertResult(boolean successful) {
		this.successful = successful;
	}

	public void then(AssertResultProcessor assertResultProcessor) {
		if (successful) {
			assertResultProcessor.onAssertSuccessful();
		} else {
			assertResultProcessor.onAssertError();
		}
	}
}
