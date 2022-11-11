package com.emat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Side bar
        Toolbar toolbar =findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        Toggle menu
        drawer =findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        if (savedInstanceState == null){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new MapsFragment()).commit();
        navigationView.setCheckedItem(R.id.Home);
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.Home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new MapsFragment()).commit();
                break;
            case R.id.nav_settings:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            new Account_Settings_Fragment()).commit();
                break;
            case  R.id.nav_wallet:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new WalletFragment()).commit();
                break;
            case R.id.nav_pay:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Account_Payment_Fragment()).commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed(){
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }
}
