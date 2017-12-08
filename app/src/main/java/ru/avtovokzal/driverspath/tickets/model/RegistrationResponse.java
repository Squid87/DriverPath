package ru.avtovokzal.driverspath.tickets.model;


import com.google.gson.annotations.SerializedName;

import ru.avtovokzal.driverspath.AbstractResponse;
//TODO нужна ли проверка на null?

public class RegistrationResponse extends AbstractResponse{

    @SerializedName("body")
    public Body mBody = new Body();

    public Body getBody() {
            return mBody;
    }
}
