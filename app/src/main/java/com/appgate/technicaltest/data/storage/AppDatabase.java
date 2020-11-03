package com.appgate.technicaltest.data.storage;

import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.appgate.technicaltest.R;
import com.appgate.technicaltest.data.AppContext;
import com.appgate.technicaltest.data.storage.entity.User;
import com.appgate.technicaltest.data.storage.entity.UserAccess;

@Database(entities = { User.class, UserAccess.class }, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();
    public abstract UserAccessDao userAccessDao();

    private static final String LOG_TAG = AppDatabase.class.getSimpleName();
    private static final Object LOCK = new Object();
    private static String DATABASE_NAME;
    private static AppDatabase sInstance;

    public static AppDatabase getInstance(Context context) {
        DATABASE_NAME = context.getResources().getString(R.string.data_base_name);
        if (sInstance == null) {
            synchronized (LOCK) {
                Log.d(LOG_TAG, "Creating new database instance");
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class, AppDatabase.DATABASE_NAME)
                        .allowMainThreadQueries().build();
            }
        }
        Log.d(LOG_TAG, "Getting the database instance");
        return sInstance;
    }
}
