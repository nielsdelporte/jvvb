package com.sorcix.jvvb;

public class Venue {

	public class Address {
		private String street;
		private String number;
		private String zipcode;
		private String city;
	}

	public class Coordinate {
		private Double latitude;
		private Double longitude;
	}

	private String id;
	private String name;
	private String website;

	private Address address;
	private Coordinate coordinates;
}
