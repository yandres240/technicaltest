package com.appgate.technicaltest.presenter.implement;

import android.content.Context;

import com.appgate.technicaltest.data.AppContext;
import com.appgate.technicaltest.data.storage.AppDatabase;
import com.appgate.technicaltest.data.storage.entity.User;
import com.appgate.technicaltest.presenter.IRegisterPresenter;
import com.appgate.technicaltest.services.IApiService;

public class RegisterPresenter implements IRegisterPresenter {
    IApiService iApiService;
    AppDatabase appDatabase;
    Context context;
    public RegisterPresenter(IApiService iApiService)
    {
        this.context = AppContext.getAppContext();
        this.iApiService = iApiService;
        this.appDatabase = AppDatabase.getInstance(context);;
    }

    public void insertUser(User user) throws Exception {
        try
        {
            appDatabase.userDao().insertAll(user);
        }
        catch (Exception ex)
        {
            throw new Exception("Ocurrio un error! " + ex.getMessage());
        }
    }

    public boolean getIsExistUser(String user)
    {
        boolean isExistUser = false;
        User userInfo = appDatabase.userDao().getUserByUserName(user);
        if(userInfo!=null)
            isExistUser = true;
        return isExistUser;
    }

    public boolean registerUser(User user) throws Exception {
        boolean isSuccess = false;
        if(!getIsExistUser(user.User))
        {
            insertUser(user);
            isSuccess = true;
        }
        return isSuccess;
    }
}
