package com.example.seminar4_;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Autocar.class}, version = 1)
public abstract class AutocareDatabase extends RoomDatabase {
    public abstract  AutocareDAO autocareDao();

}
