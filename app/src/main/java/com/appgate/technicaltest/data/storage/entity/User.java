package com.appgate.technicaltest.data.storage.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "uid")
    public String Uid;

    @ColumnInfo(name = "user")
    public String User;

    @ColumnInfo(name = "password")
    public String Password;

    @ColumnInfo(name = "firstName")
    public String FirstName;

    @ColumnInfo(name = "lastName")
    public String LastName;

    @ColumnInfo(name = "telephone")
    public String Telephone;

    @ColumnInfo(name = "status")
    public boolean Status;
}