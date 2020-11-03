package com.appgate.technicaltest.presenter.implement;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.appgate.technicaltest.data.AppContext;
import com.appgate.technicaltest.data.storage.AppDatabase;
import com.appgate.technicaltest.data.storage.entity.User;
import com.appgate.technicaltest.data.storage.entity.UserAccess;
import com.appgate.technicaltest.presenter.ILoginPresenter;
import com.appgate.technicaltest.services.IApiService;
import com.appgate.technicaltest.services.Models.Api;
import com.appgate.technicaltest.services.Models.ApiRequest;
import com.appgate.technicaltest.services.Models.ParameterHeader;
import com.appgate.technicaltest.services.Models.Response.TimeZoneResponse;
import com.appgate.technicaltest.services.Models.TypeRequest;
import com.appgate.technicaltest.utils.LocationServices;
import com.google.gson.Gson;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class LoginPresenter implements ILoginPresenter {
    IApiService iApiService;
    AppDatabase appDatabase;
    Context context;

    public LoginPresenter(IApiService iApiService)
    {
        this.context = AppContext.getAppContext();
        this.iApiService = iApiService;
        this.appDatabase = AppDatabase.getInstance(context);;
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

    public boolean getIsValidUser(String user, String password)
    {
        boolean isValidUser = false;
        /*AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                // Insert Data
                AppDatabase.getInstance(context).userDao().insert(new User(1,"James","Mathew"));

                // Get Data
                AppDatabase.getInstance(context).userDao().getAllUsers();
            }
        });*/
        User userInfo = appDatabase.getInstance(context).userDao().getUserByUserName(user);
        if(userInfo!=null)
        {
            if(userInfo.Password.equals(password))
                isValidUser = true;
        }
        return isValidUser;
    }

    public User getInfoUser(String user)
    {
        boolean isValidUser = false;
        User userInfo = appDatabase.getInstance(context).userDao().getUserByUserName(user);
        return userInfo;
    }

    public void insertUserAccess(UserAccess userAccess) throws Exception {
        try
        {
            appDatabase.getInstance(context).userAccessDao().insertAll(userAccess);
        }
        catch (Exception ex)
        {
            throw new Exception("Ocurrio un error! " + ex.getMessage());
        }
    }

    public boolean loginUser(String user, String password) throws Exception {
        boolean isSuccess = false;
        if(getIsValidUser(user, password)) {
            User userInfo = getInfoUser(user);
            if(userInfo!=null) {
                LocationServices gps = new LocationServices(context);
                int status = 0;
                if (gps.canGetLocation()) {
                    TimeZoneResponse timeZoneResponse = GetDate(Double.toString(gps.getLatitude()), Double.toString(gps.getLongitude()));
                    UserAccess userAccess = new UserAccess();
                    userAccess.Uid = UUID.randomUUID().toString().replace("-", "");
                    userAccess.Date = timeZoneResponse.getTime();
                    userAccess.Status = true;
                    userAccess.UidUser = userInfo.Uid;

                    insertUserAccess(userAccess);
                    isSuccess = true;
                } else {
                    gps.showSettingsAlert();
                }
            }
        }
        return isSuccess;
    }
}
