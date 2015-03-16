package com.sorcix.jvvb;

public class Venue {

	public class Address {
		private String street;
		private String number;
		private String zipcode;
		private String city;
	}

	public class Coordinate {
		private String latitude;
		private String longitude;
	}

	private String id;
	private String name;
	private String website;

	private Address address;
	private Coordinate coordinates;
}
