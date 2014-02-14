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

	public void then(AssertResultProcessor assertResultProcessor) throws AssertException {
		if (successful) {
			assertResultProcessor.onAssertSuccessful();
		} else {
			String assertErrorDescription = assertResultProcessor.onAssertError();
			throw new AssertException(assertErrorDescription, cause);
		}
	}

	public boolean isSatisfied() {
		return successful;
	}
}
