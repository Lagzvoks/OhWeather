package com.dikamjitborah.hobarb.ohweather.views.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.dikamjitborah.hobarb.ohweather.R;
import com.dikamjitborah.hobarb.ohweather.views.fragment.HomeFragment;
import com.dikamjitborah.hobarb.ohweather.views.fragment.SettingsFragment;
import com.dikamjitborah.hobarb.ohweather.views.utilities.Constants;
import com.google.android.material.navigation.NavigationView;

import java.awt.font.TextAttribute;

public class Home extends AppCompatActivity {

    Toolbar toolbar;
    FrameLayout frameLayout;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    String[] drawer_items;
    int menuItemIndex = 0;
    int menuItemIndex_right = 0;
    private String TAG_CURRENT = Constants.TAG_HOME;
    private Handler handler;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if(menuItemIndex_right == 0)
            getMenuInflater().inflate(R.menu.right_menu_items, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        handler = new Handler();
        toolbar = findViewById(R.id.toolbar_nav_appbar);
        frameLayout = findViewById(R.id.framelayout_nav_appbar);
        drawerLayout = findViewById(R.id.drawer_home);
        navigationView = findViewById(R.id.nav_view_home);
        setSupportActionBar(toolbar);
        drawer_items = getResources().getStringArray(R.array.navigation_menu_items);
        getSelectedFragment();
        setNavigationView();


        if (savedInstanceState == null) {
            menuItemIndex = 0;
            TAG_CURRENT = Constants.TAG_HOME;
            loadFragment();

        }


    }

    private void loadFragment() {
        navigationView.getMenu().getItem(menuItemIndex).setChecked(true);
        getSupportActionBar().setTitle(drawer_items[menuItemIndex]);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Fragment fragment = getSelectedFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.framelayout_nav_appbar, fragment, TAG_CURRENT);
                fragmentTransaction.commitAllowingStateLoss();
            }
        };

        handler.post(runnable);
        drawerLayout.closeDrawers();
        invalidateOptionsMenu();

    }

    private Fragment getSelectedFragment() {
        switch (menuItemIndex) {
            case 0:
                //the home fragment
                HomeFragment homeFragment = new HomeFragment();
                return homeFragment;
            case 1:
                //Settings fragment
                SettingsFragment settingsFragment = new SettingsFragment();
                return settingsFragment;

            default:
                return new HomeFragment();

        }

    }


    private void setNavigationView() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.item_home:
                        menuItemIndex = 0;
                        TAG_CURRENT = Constants.TAG_HOME;
                        break;
                    case R.id.item_settings:
                        menuItemIndex = 1;
                        TAG_CURRENT = Constants.TAG_SETTINGS;
                        break;
                    default:
                        menuItemIndex = 0;
                        break;
                }

                if (menuItem.isChecked()) {
                    menuItem.setChecked(false);
                } else {
                    menuItem.setChecked(true);
                }
                menuItem.setChecked(true);

                loadFragment();

                return true;
            }
        });

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.openDrawer, R.string.closeDrawer) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }


        };
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }


}
