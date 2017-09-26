package ru.avtovokzal.driverspath.network;


import java.util.List;
import java.util.Observable;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;
import ru.avtovokzal.driverspath.model.RegistrationResponse;
import ru.avtovokzal.driverspath.model.TicketInfo;

public interface TicketApiInterface {

    @POST("/avsrouter/transit/getTripInfo")
    Call<RegistrationResponse> getTicketInfo(@Header("Authorization") String auth, @Header("Content-Type") String contentType, @Header("Accept") String accept, @Body RegistrationBody registrationBody);

}
