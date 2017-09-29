package ru.avtovokzal.driverspath.model;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class RegistrationResponse {

    @SerializedName("body")
    public Body mBody = new Body();

    public Body getBody() {
        return mBody;
    }

}
