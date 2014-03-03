package com.civila.model;

public class Persona {
	private String name;

	public Persona() {
	}

	public Persona(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Persona)) return false;

		Persona persona = (Persona) o;

		return name.equals(persona.name);
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}
}
