package com.appgate.technicaltest.presenter;

import com.appgate.technicaltest.data.storage.entity.User;

public interface IRegisterPresenter {
    void insertUser(User user) throws Exception;
    boolean getIsExistUser(String user);
    boolean registerUser(User user) throws Exception;
}
