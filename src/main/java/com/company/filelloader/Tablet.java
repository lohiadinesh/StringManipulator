package com.company.filelloader;

import java.nio.ByteBuffer;

class Tablet implements Persistable {

	private String brand;
	private boolean isCellular;
	private long cost; // in US Dollars

	public Tablet() {
		brand = "";
	}

	public Tablet(String brand, boolean isCellular, long cost) {
		this.brand = brand;
		this.isCellular = isCellular;
		this.cost = cost;
	}

	public final String getBrand() {
		return brand;
	}

	public final boolean isCellular() {
		return isCellular;
	}

	public final long getCost() {
		return cost;
	}

	public final void setBrand(String brand) {
		this.brand = brand;
	}

	public final void setCellular(boolean isCellular) {
		this.isCellular = isCellular;
	}

	public final void setCost(long cost) {
		this.cost = cost;
	}

	@Override
	public void persist(ByteBuffer buffer) {
		byte[] strBytes = brand.getBytes();
		buffer.putInt(strBytes.length);
		buffer.put(strBytes, 0, strBytes.length);
		buffer.put(isCellular == true ? (byte) 1 : (byte) 0);
		buffer.putLong(cost);
	}

	@Override
	public void recover(ByteBuffer buffer) {
		int size = buffer.getInt();
		byte[] rawBytes = new byte[size];
		buffer.get(rawBytes, 0, size);
		this.brand = new String(rawBytes);
		this.isCellular = buffer.get() == 1 ? true : false;
		this.cost = buffer.getLong();
	}

	@Override
	public String toString() {
		return "Tablet [brand=" + brand + ", isCellular=" + isCellular + ", cost=" + cost + "]";
	}

}
