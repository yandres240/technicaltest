package com.appgate.technicaltest.presenter;

import com.appgate.technicaltest.data.storage.entity.UserAccess;

import java.util.List;

public interface IHomePresenter {
    List<UserAccess> GetUserAccess(String uid);
}
