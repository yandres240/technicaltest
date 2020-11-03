package com.appgate.technicaltest.data.storage;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.appgate.technicaltest.data.storage.entity.User;
import com.appgate.technicaltest.data.storage.entity.UserAccess;

import java.util.List;

@Dao
public interface UserAccessDao {
    @Query("SELECT * FROM UserAccess")
    List<UserAccess> getAll();

    @Query("SELECT * FROM UserAccess WHERE uidUser IN (:userIds)")
    List<UserAccess> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM UserAccess WHERE uidUser = :uid")
    List<UserAccess> getUserAccess(String uid);

    @Insert
    void insertAll(UserAccess... usersAccesses);

    @Delete
    void delete(UserAccess userAccess);

    @Update
    void update(UserAccess userAccess);
}

