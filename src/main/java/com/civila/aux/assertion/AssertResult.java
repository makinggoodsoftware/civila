package com.civila.aux.assertion;

public class AssertResult {
	private final boolean successful;
	private final AssertException cause;

	public AssertResult(boolean successful, String errorDesc) {
		this.successful = successful;
		if (errorDesc!=null){
			this.cause = new AssertException(errorDesc);
		} else {
			this.cause = null;
		}
	}

	public AssertResult(boolean successful, AssertException cause) {
		this.successful = successful;
		this.cause = cause;
	}

	public void then(AssertResultProcessor assertResultProcessor) throws AssertException {
		if (successful) {
			assertResultProcessor.onAssertSuccessful();
		} else {
			assertResultProcessor.onAssertError(cause);
		}
	}
}
