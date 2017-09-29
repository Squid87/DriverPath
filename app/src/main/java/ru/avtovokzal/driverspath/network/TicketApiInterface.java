package ru.avtovokzal.driverspath.network;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import ru.avtovokzal.driverspath.model.RegistrationResponse;

public interface TicketApiInterface {

    @POST("/avsrouter/transit/getTripInfo")
    Call<RegistrationResponse> getTicketInfo(@Header("Authorization") String auth, @Body RegistrationBody registrationBody);
//    Call<RegistrationResponse> getTicketInfo(@Header("Authorization") String auth, @Header("Content-Type") String contentType, @Header("Accept") String accept, @Body RegistrationBody registrationBody);

}
