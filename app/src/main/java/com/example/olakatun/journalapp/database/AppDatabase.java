package com.example.olakatun.journalapp.database;

import android.content.Context;
import android.util.Log;

//import android.annotation.IdTypeConverters;

@Database(entities = {JournalEntry.class}, version = 1, exportScema = false)
@TypeConverters(DateConverter.class)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase appDatabase;
    private static final String DATABASE_NAME = "journalDB";
    private static final String LOG_TAG = AppDatabase.class.getSimpleName();
    private static final Object LOCK = new Object();

    public static AppDatabase getAppDatabase(Context context){

        if(appDatabase == null){
            synchronized (LOCK){
                Log.d(LOG_TAG,  "Creating new database instance");
                appDatabase = Room.databaseBuilder(context.getApplicationContext(),
                        AppDatabase.class, AppDatabase.DATABASE_NAME)

                        //it a test. remove later.
                        .allowMainThreadQueries()
                        .build();
            }
        }

        Log.d(LOG_TAG, "getting the database instance");
        return appDatabase;
    }

    public abstract JournalDao journalDao();
}
