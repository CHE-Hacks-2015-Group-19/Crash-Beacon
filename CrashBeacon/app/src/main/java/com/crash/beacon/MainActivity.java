package com.crash.beacon;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import com.crash.beacon.Book;
import com.firebase.client.Firebase;
import com.syncano.library.Syncano;
import com.syncano.library.api.Response;


public class MainActivity extends AppCompatActivity implements SensorEventListener, LocationListener {
    boolean isEnabled = false;
    Button btn;
    String[] listItems = new String[]{"Home", "About", "Website"};
    float lat = 0, lng = 0, alt = 0;
    Sensor accel;
    SensorManager manager;
    Firebase base;
    float x = 0, y = 0, z = 0;
    private ActionBarDrawerToggle mDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);
        btn = (Button)findViewById(R.id.crash);
        gui(isEnabled);
        manager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accel = manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        base = new Firebase("https://crash-beacon.firebaseio.com");
        // Get the location manager
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        // Define the criteria how to select the locatioin provider -> use
        // default
        Criteria criteria = new Criteria();
        String provider = locationManager.getBestProvider(criteria, false);

        Location location = locationManager.getLastKnownLocation(provider);

        // Initialize the location fields
        if (location != null) {
           onLocationChanged(location);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
    public void onCrash(View view){
          isEnabled = !isEnabled;
          gui(isEnabled);
          base.child("hello").setValue("Hello Firebase");


    }
    public void gui(boolean state){
        if(state){
            btn.setText("Enabled");
            btn.setBackgroundDrawable(getResources().getDrawable(R.drawable.enabled));
        }
        else{
            btn.setText("Disabled");
            btn.setBackgroundDrawable(getResources().getDrawable(R.drawable.disabled));

        }
    }

    @Override
    protected void onResume(){
        super.onResume();
        manager.registerListener(this, accel, SensorManager.SENSOR_DELAY_NORMAL);

    }
    @Override
    protected void onPause(){
        super.onPause();
        manager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        x = event.values[0];
        y = event.values[1];
        z = event.values[2];
        //Demo values
        //For actual deployment, use lat, alt, and lng variables
        float hLat = 39, hLng = -75, hAlt = 25;


        if(isEnabled){
            if(Math.abs(x) > 20 && Math.abs(y) > 20 && Math.abs(z) > 20){

            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void onLocationChanged(Location location) {
        lat = (float)location.getLatitude();
        lng = (float)location.getLongitude();
        alt = (float)location.getAltitude();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
