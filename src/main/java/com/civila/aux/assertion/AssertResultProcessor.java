package com.civila.aux.assertion;

public interface AssertResultProcessor {
	public void onAssertSuccessful();
	public void onAssertError(AssertException cause) throws AssertException;
}
