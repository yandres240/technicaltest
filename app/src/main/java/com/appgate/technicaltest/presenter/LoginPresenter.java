package com.appgate.technicaltest.presenter;

import com.appgate.technicaltest.services.IApiService;
import com.appgate.technicaltest.services.Models.Api;
import com.appgate.technicaltest.services.Models.ApiRequest;
import com.appgate.technicaltest.services.Models.ParameterHeader;
import com.appgate.technicaltest.services.Models.Response.TimeZoneResponse;
import com.appgate.technicaltest.services.Models.TypeRequest;
import com.google.gson.Gson;

import java.util.ArrayList;

public class LoginPresenter implements ILoginPresenter{
    IApiService iApiService;
    public LoginPresenter(IApiService iApiService){
        this.iApiService = iApiService;
    }

    public TimeZoneResponse GetDate(String lat, String lng){
        try {
            ArrayList<ParameterHeader> queryParameters = new ArrayList<>();
            queryParameters.add(new ParameterHeader("formatted", "true"));
            queryParameters.add(new ParameterHeader("lat", lat));
            queryParameters.add(new ParameterHeader("lng", lng));
            queryParameters.add(new ParameterHeader("username", "qa_mobile_easy"));
            queryParameters.add(new ParameterHeader("style", "full"));
            ApiRequest apiRequest = new ApiRequest(Api.GEONAMES, TypeRequest.GET, null, "timezoneJSON", null, queryParameters);
            Gson gson = new Gson();
            TimeZoneResponse timeZoneResponse = gson.fromJson(iApiService.Execute(apiRequest), TimeZoneResponse.class);
            return timeZoneResponse;
        }
        catch (Exception ex){
            return null;
        }
    }
}
