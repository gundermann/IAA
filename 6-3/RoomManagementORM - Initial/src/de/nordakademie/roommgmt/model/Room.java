package de.nordakademie.roommgmt.model;

import java.io.Serializable;


public class Room implements Serializable{

	private static final long serialVersionUID = 616224522362451909L;
	private Long id;
	private String building;
	private int roomNumber;
	private int seatCount;
	private boolean beamerPresent;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public int getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}

	public boolean isBeamerPresent() {
		return beamerPresent;
	}

	public void setBeamerPresent(boolean beamer) {
		this.beamerPresent = beamer;
	}

}
