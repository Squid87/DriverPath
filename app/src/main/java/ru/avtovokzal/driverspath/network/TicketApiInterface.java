package ru.avtovokzal.driverspath.network;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;
import ru.avtovokzal.driverspath.modelStation.StationResponse;
import ru.avtovokzal.driverspath.modelStation.StationResponseBody;
import ru.avtovokzal.driverspath.modelTicketUpdate.TicketUpdateResponse;
import ru.avtovokzal.driverspath.modelTickets.RegistrationResponse;

public interface TicketApiInterface {

    @POST("/avsrouter/transit/getTripInfo")
    Call<RegistrationResponse> getTicketInfo(@Header("Authorization") String auth, @Body RegistrationBody registrationBody);

    @POST("/avsrouter/api/avdriver/tripInfo")
    Call<StationResponseBody> getStationInfo(@Header("Authorization") String auth, @Body RegistrationBody registrationBody);

    @POST("/avsrouter/api/avdriver/updateTicket")
    Call<TicketUpdateResponse> setUpdateTicket(@Header("Authorization") String auth, @Body UpdateTicket updateTicket);

}
