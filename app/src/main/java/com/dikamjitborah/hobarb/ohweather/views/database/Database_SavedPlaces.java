package com.dikamjitborah.hobarb.ohweather.views.database;


import androidx.room.Database;
import androidx.room.RoomDatabase;

//@Database(entities =  (Model_SavedPlaces.class), version=1, exportSchema = false)
public abstract class Database_SavedPlaces extends RoomDatabase {

    public abstract Interface_DaoAccess interface_daoAccess();
}
