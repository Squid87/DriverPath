package ru.avtovokzal.driverspath.modelTickets;


import com.google.gson.annotations.SerializedName;
//TODO нужна ли проверка на null?

public class RegistrationResponse {

    @SerializedName("body")
    public Body mBody = new Body();

    public Body getBody() {
            return mBody;
    }
}
