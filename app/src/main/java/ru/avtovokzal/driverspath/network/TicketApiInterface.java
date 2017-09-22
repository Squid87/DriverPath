package ru.avtovokzal.driverspath.network;


import java.util.List;
import java.util.Observable;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import ru.avtovokzal.driverspath.model.RegistrationResponse;
import ru.avtovokzal.driverspath.model.TicketInfo;

public interface TicketApiInterface {

    @POST("/avsrouter/transit/getTripInfo")
    Call<TicketInfo> getTicketInfo(@Body RegistrationBody registrationBody);

    //rx.Observable<List<TicketInfo>> getTicketInfo(@Body RegistrationBody registrationBody);

    //RegistrationResponse registerUser(@Body RegistrationBody registrationBody);
}
