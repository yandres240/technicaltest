package com.appgate.technicaltest.presenter;

import com.appgate.technicaltest.data.storage.entity.UserAccess;
import com.appgate.technicaltest.services.Models.Response.TimeZoneResponse;

public interface ILoginPresenter {
    TimeZoneResponse GetDate(String lat, String lng);
    boolean getIsValidUser(String user, String password);
    void insertUserAccess(UserAccess userAccess) throws Exception;
    boolean loginUser(String user, String password) throws Exception;
}
