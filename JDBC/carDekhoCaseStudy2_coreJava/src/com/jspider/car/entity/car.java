package com.jspider.car.entity;

import java.util.Objects;

public class car {
	private int id;
	private String brand;
	private String name;
	private String fuelType;
	private String colour;
	private double price;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	@Override
	public String toString() {
		return "car [id=" + id + ", name=" + name + " brand=" + brand + " fuelType=" + fuelType + ", colour=" + colour
				+"Price="+price+ "]\n";
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		car other = (car) obj;
		return Objects.equals(brand, other.brand) && Objects.equals(colour, other.colour)
				&& Objects.equals(fuelType, other.fuelType) && id == other.id && Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}

	
	
	

	

}
