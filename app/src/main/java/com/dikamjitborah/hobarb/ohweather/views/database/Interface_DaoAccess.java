package com.dikamjitborah.hobarb.ohweather.views.database;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface Interface_DaoAccess {

    @Insert
    Long insertTask(Model_SavedPlaces model_savedPlaces);

    @Query("SELECT * FROM Model_SavedPlaces ORDER BY time_stamp")
    List<Model_SavedPlaces> retreivedTasks();
    @Query("DELETE FROM Model_SavedPlaces WHERE id = id")
    public void deleteByID(String id);



}
