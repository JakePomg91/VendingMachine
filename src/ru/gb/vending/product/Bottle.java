package ru.gb.vending.product;

public class Bottle extends Product {
	private  double volume;



	public Bottle(String name, double price, double volume) {
		super(name, price);
		this.volume = volume;
	}

	public double getVolume() {
		return volume;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder(super.toString());
		stringBuilder.insert((int) (stringBuilder.length() - (9 + priceLen(super.getPrice()))), " volume: " + volume + ",");
		return stringBuilder.toString();
	}

	private int priceLen(double price) {
		return Double.toString(price).length();
	}

}
