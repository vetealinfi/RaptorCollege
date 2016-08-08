package com.codebake.raptor.raptorcollege;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.codebake.raptor.raptorcollege.adapter.IFragmentToActivity;
import com.codebake.raptor.raptorcollege.adapter.PagerAdapter;
import com.codebake.raptor.raptorcollege.ui.TabFragment3;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import Modelo.ColegioTransporte;
import util.AndroidUtils;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{


    private final String LOG_TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout2);
        tabLayout.addTab(tabLayout.newTab().setText("Elije donde cazar"));
        tabLayout.addTab(tabLayout.newTab().setText("Selecciona tu presa"));
        tabLayout.addTab(tabLayout.newTab().setText("Atrápalo"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ColegioTransporte colegioTransporte = new ColegioTransporte();


        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);


        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount(),viewPager,colegioTransporte);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                Log.d("test", "currentTab "+ tab.getPosition());
                if(colegioTransporte.getHayObjetoColegioActivo()==1 && colegioTransporte.getHayCampoMapa()==1){
                    TextView mTextView1 = colegioTransporte.getmTextView1();
                    mTextView1.setText(colegioTransporte.getColegioActivo().getName());
                    colegioTransporte.getMtextoMapaDireccion().setText(colegioTransporte.getColegioActivo().getAddress());
                    colegioTransporte.getMtextoMapaTelefono().setText(colegioTransporte.getColegioActivo().getPhone());
                    if(colegioTransporte.getHayGoogleMap()==1){
                        colegioTransporte.getmGoogleMap().clear();

                        Marker marker = colegioTransporte.getmGoogleMap().addMarker(new MarkerOptions().position(new LatLng(colegioTransporte.getColegioActivo().getLatitude(), colegioTransporte.getColegioActivo().getLongitude())).title(colegioTransporte.getColegioActivo().getName()));
                        colegioTransporte.getmGoogleMap().moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(colegioTransporte.getColegioActivo().getLatitude(), colegioTransporte.getColegioActivo().getLongitude()), 3));
                        colegioTransporte.getmGoogleMap().animateCamera( CameraUpdateFactory.zoomTo(15) );
                        marker.showInfoWindow();
                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        //viewPager.setCurrentItem(3);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.For more information see https://docs.gradle.org/current/userguide/build_environment.html
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent intent = new Intent(this,ResultadoColegiosActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_gallery) {
            Intent intent = new Intent(this,PruebaTabActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_slideshow) {
            Intent intent = new Intent(this,PruebaTab2Activity.class);
            startActivity(intent);
        } else if (id == R.id.nav_manage) {
            Intent intent = new Intent(this,MapsActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void enviaNotification(View view) {

        String mensaje = "aaaaaa";
        AndroidUtils.enviarNotificacion(this,mensaje,R.drawable.ic_menu_camera,SplashActivity.class);
    }



    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }



}
