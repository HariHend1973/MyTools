package com.kutukupret.mytools;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.muddzdev.styleabletoast.StyleableToast;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new SettingsFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_settings);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_message:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new MessageFragment()).commit();
                break;
            case R.id.nav_chat:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ChatFragment()).commit();
                break;
            case R.id.nav_profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ProfileFragment()).commit();
                break;
            case R.id.nav_settings:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SettingsFragment()).commit();
                break;
            case R.id.nav_tikapp:
                PackageManager pm_tikapp = getPackageManager();
                Intent intent_tikapp = pm_tikapp.getLaunchIntentForPackage("com.mikrotik.android.tikapp");
                if (intent_tikapp != null) {
                    startActivity(intent_tikapp);
                }
                break;
            case R.id.nav_speedtest:
                PackageManager pm_speedtest = getPackageManager();
                Intent intent_speedtest = pm_speedtest.getLaunchIntentForPackage("org.zwanoo.android.speedtest");
                if (intent_speedtest != null) {
                    startActivity(intent_speedtest);
                }
                break;
            case R.id.nav_vpn:
                PackageManager pm_vpn = getPackageManager();
                Intent intent_vpn = pm_vpn.getLaunchIntentForPackage("it.claudio.chimera.vpn");
                if (intent_vpn != null) {
                    startActivity(intent_vpn);
                }
                break;
            case R.id.nav_share:
                //Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                //StyleableToast.makeText(this, "Share", R.style.exampleToast).show();\
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ShareFragment()).commit();
                break;
            case R.id.nav_send:
                //Toast.makeText(this, "Send", Toast.LENGTH_SHORT).show();
                //StyleableToast.makeText(this, "Send", R.style.exampleToast).show();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SendFragment()).commit();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void showToast(View v) {
        StyleableToast.makeText(this, "Hello World!", R.style.exampleToast).show();
    }
}
