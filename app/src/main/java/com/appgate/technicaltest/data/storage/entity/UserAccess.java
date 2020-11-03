package com.appgate.technicaltest.data.storage.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = User.class,
        parentColumns = "uid",
        childColumns = "uidUser",
        onDelete = ForeignKey.CASCADE))
public class UserAccess {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "uid")
    public String Uid;

    @ColumnInfo(name = "uidUser")
    public String UidUser;

    @ColumnInfo(name = "date")
    public String Date;

    @ColumnInfo(name = "status")
    public boolean Status;
}
