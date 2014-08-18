package de.nordakademie.roommgmt.model;

import java.io.Serializable;

/**
 * The room entity.
 */
public class Room implements Serializable {

	/** The serial version uid. */
	private static final long serialVersionUID = 7664217191744579056L;

	/** The identifier. */
	private Long id;
	/** The building. */
	private String building;
	/** The room number. */
	private int roomNumber;
	/** The seat count. */
	private int seats;
	/** The beamer information. */
	private boolean beamer;

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

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public boolean isBeamer() {
		return beamer;
	}

	public void setBeamer(boolean beamer) {
		this.beamer = beamer;
	}

	/** {@inheritDoc} */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((building == null) ? 0 : building.hashCode());
		result = prime * result + roomNumber;
		return result;
	}

	/** {@inheritDoc} */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Room other = (Room) obj;
		if (building == null) {
			if (other.building != null)
				return false;
		} else if (!building.equals(other.building))
			return false;
		if (roomNumber != other.roomNumber)
			return false;
		return true;
	}
}