package com.appgate.technicaltest.presenter.implement;

import android.content.Context;

import com.appgate.technicaltest.data.AppContext;
import com.appgate.technicaltest.data.storage.AppDatabase;
import com.appgate.technicaltest.data.storage.entity.UserAccess;
import com.appgate.technicaltest.presenter.IHomePresenter;
import com.appgate.technicaltest.services.IApiService;

import java.util.List;

public class HomePresenter implements IHomePresenter {
    IApiService iApiService;
    AppDatabase appDatabase;
    Context context;
    public HomePresenter(IApiService iApiService)
    {
        this.context = AppContext.getAppContext();
        this.iApiService = iApiService;
        this.appDatabase = AppDatabase.getInstance(context);;
    }

    public List<UserAccess> GetUserAccess(String uid)
    {
        List<UserAccess> userAccesses = appDatabase.userAccessDao().getUserAccess(uid);
        return userAccesses;
    }
}
