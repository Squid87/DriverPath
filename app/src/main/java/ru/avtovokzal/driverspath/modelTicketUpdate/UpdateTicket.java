package ru.avtovokzal.driverspath.modelTicketUpdate;


import ru.avtovokzal.driverspath.network.RouteKey;

public class UpdateTicket {

    private String date;
    private boolean isGone;
    private String ticketId;

   public RouteKey routeKey = new RouteKey();

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public boolean isGone() {
        return isGone;
    }

    public void setGone(boolean gone) {
        isGone = gone;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }
}
