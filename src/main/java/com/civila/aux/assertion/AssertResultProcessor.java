package com.civila.aux.assertion;

public interface AssertResultProcessor {
	public void onAssertSuccessful();
	public String onAssertError();
}
