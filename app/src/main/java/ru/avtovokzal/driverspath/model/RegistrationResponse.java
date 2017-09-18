package ru.avtovokzal.driverspath.model;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class RegistrationResponse {

    @SerializedName("body")
    public List<TicketInfo> mTicketInfo = new ArrayList<>();

    public List<TicketInfo> getTicketInfos() {
        return mTicketInfo;
    }


}
