package ru.avtovokzal.driverspath.network;


import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;
import ru.avtovokzal.driverspath.model.RegistrationResponse;

public interface DriverPathApiInterface {

    @POST("/avsrouter/transit/getTripInfo")
    RegistrationResponse registerUser(@Body RegistrationBody registrationBody);
}
