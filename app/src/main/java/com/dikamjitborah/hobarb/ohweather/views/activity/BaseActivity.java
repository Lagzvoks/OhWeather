package com.dikamjitborah.hobarb.ohweather.views.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.pm.PackageManager;
import android.os.Bundle;

import com.dikamjitborah.hobarb.ohweather.R;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    public int check_permissions(String[] permissions)
    {
        int result;
        int permission_denied = 0;
        for(int i = 0; i<=permissions.length+1; i++)
        {
            result = ContextCompat.checkSelfPermission(this, permissions[i]);
            if(result!= PackageManager.PERMISSION_GRANTED)
            {
                permission_denied++;
            }

        }
        return permission_denied;
    }


}