package com.appgate.technicaltest.services;

import com.appgate.technicaltest.services.Models.ApiRequest;

public interface IApiService<T> {
    String Execute(ApiRequest apiRequest) throws Exception;
}
