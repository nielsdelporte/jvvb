package com.sorcix.jvvb;

import org.json.JSONObject;

public class Club {

	private String id;
	private String number;
	private String name;
	private String website;

	public Club(String id, String number, String name, String website) {
		this.id = id;
		this.number = number;
		this.name = name;
		this.website = website;
	}

	public Club(JSONObject json) {
		this.id = json.getString("club_id");
		this.number = json.getString("club_number");
		this.name = json.getString("club_name");
		this.website = json.getString("club_website");
	}

	@Override
	public String toString() {
		return this.name;
	}

	@Override
	public boolean equals(Object other) {
		if(this == other) {
			return true;
		}
		if(!(other instanceof Club)) {
			return false;
		}
		if(this.id == ((Club)other).id) {
			return true;
		}
		return false;
	}

	public String getID() {
		return this.id;
	}

	public void setID(String id) {
		this.id = id;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return this.name;;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String name) {
		this.website = website;
	}

}
