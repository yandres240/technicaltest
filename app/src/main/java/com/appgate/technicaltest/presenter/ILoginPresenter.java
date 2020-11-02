package com.appgate.technicaltest.presenter;

import com.appgate.technicaltest.services.Models.Response.TimeZoneResponse;

public interface ILoginPresenter {
    TimeZoneResponse GetDate(String lat, String lng);
}
