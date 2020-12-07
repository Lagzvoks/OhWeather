package com.dikamjitborah.hobarb.ohweather.views.database;

import android.content.Context;
import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

import androidx.room.Database;
import androidx.room.Room;

public class Repository_SavedPlaces {

    String database_name = "locations_database";
    List<Model_SavedPlaces> savedPlaces = new ArrayList<>();
    Database_SavedPlaces database_savedPlaces;

    public Repository_SavedPlaces(Context context)
    {
        database_savedPlaces = Room.databaseBuilder(context, Database_SavedPlaces.class, database_name).build();
    }

    public void insertTask(final Model_SavedPlaces model_savedPlaces)
    {
        new AsyncTask<Void, Void, Long>(){
            @Override
            protected Long doInBackground(Void... voids) {
                return null;
            }
        }.execute();
    }

   /* public void getTasks(){
        new AsyncTask<Void, Void, List<Model_SavedPlaces>>(){
            @Override
            protected List<Model_SavedPlaces> doInBackground(Void... voids) {
                savedPlaces = database_savedPlaces.interface_daoAccess().retreivedTasks();
            }

            @Override
            protected void onPostExecute(List<Model_SavedPlaces> model_savedPlaces) {
                super.onPostExecute(model_savedPlaces);
            }
        }.execute();
    }*/



}
