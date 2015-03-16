package com.sorcix.jvvb;

public class BaseTeam {
	private String id;
	private String name;

	public BaseTeam(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getID() {
		return this.id;
	}

	public void setID(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
