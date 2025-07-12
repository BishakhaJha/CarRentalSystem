package com.bishakha.carrental.model;

public class Car {
    private String id;
    private String model;
    private boolean rented;

    public Car() {}

    public Car(String id, String model) {
        this.id = id;
        this.model = model;
        this.rented = false;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}

	public boolean isRented1() {
		// TODO Auto-generated method stub
		return false;
	}
}