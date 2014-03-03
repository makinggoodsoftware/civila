package com.civila.aux.assertion;

public class AssertionRunner {
	public AssertContinuation run(Assertion assertion) {
		boolean condition;
		String errorDesc = assertion.assertionErrorDescription();

		try {
			condition = assertion.condition();
		} catch (AssertException source) {
			throw new AssertException(errorDesc, source);
		}

		if (condition){
			return new AssertContinuation();
		}else{
			throw new AssertException(errorDesc);
		}
	}

	public static class AssertContinuation {
		public void then(AssertResultProcessor assertResultProcessor) throws AssertException {
			assertResultProcessor.execute();
		}

		public boolean isSatisfied() {
			return true;
		}
	}
}
