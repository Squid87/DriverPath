package ru.avtovokzal.driverspath.modelStation;

import com.google.gson.annotations.SerializedName;

public class StationTicket {

	public String direction;

	@SerializedName("dispatchStationUid")
	public String mDispatchStationId;

	@SerializedName("dispatchStationName")
	public String mDispatchStationName;

	@SerializedName("arrivalStationUid")
	public String mArrivalStationId;

	@SerializedName("arrivalStationName")
	public String mArrivalStationName;

	@SerializedName("passenger")
	public Passenger mPassenger;

	@SerializedName("ticketId")
	public String mTicketId;

	@SerializedName("ticketSeries")
	public String mTicketSeries;

	@SerializedName("ticketNumber")
	public String mTicketNumber;

	@SerializedName("seatNum")
	public int mSeatNum;

	@SerializedName("agent")
	public String mAgent;

	@SerializedName("price")
	public int mPrice;

	@SerializedName("isGone")
	public boolean mIsGone;

	public Passenger getPassenger() {
		return mPassenger;
	}

	public void setPassenger(Passenger passenger) {
		mPassenger = passenger;
	}

	public int getSeatNum() {
		return mSeatNum;
	}

	public String getTicketId() {
		return mTicketId;
	}

	public boolean isGone() {
		return mIsGone;
	}

	public void setIsGone(boolean mIsGone) {
		this.mIsGone = mIsGone;
	}

	public void setTicketId(String mTicketId) {
		this.mTicketId = mTicketId;
	}

	public int getPrice() {
		return mPrice;
	}

	public void setPrice(int price) {
		mPrice = price;
	}
}
