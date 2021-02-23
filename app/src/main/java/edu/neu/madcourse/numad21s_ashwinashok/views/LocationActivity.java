package edu.neu.madcourse.numad21s_ashwinashok.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import edu.neu.madcourse.numad21s_ashwinashok.R;

public class LocationActivity extends AppCompatActivity implements LocationListener {
    private static final int REQUEST_LOCATION = 1;

    Button get_location_button;
    TextView display_location_text_view;
    LocationManager locationManager;
    String location_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        display_location_text_view = findViewById(R.id.location_text);
        get_location_button = findViewById(R.id.get_location_button);

        if(savedInstanceState != null) {
            location_text = savedInstanceState.getString("location");
            display_location_text_view.setText(location_text);
        }

        get_location_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                locationManager = (LocationManager) getApplicationContext().getSystemService(LOCATION_SERVICE);

                // Check for location sensor availability
                if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {

                    final AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                    builder.setMessage("Enable GPS").setCancelable(false).setPositiveButton("Yes", new  DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                        }
                    }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });

                    final AlertDialog alertDialog = builder.create();
                    alertDialog.show();


                } else {
                    getLocation();
                }
            }
        });
    }


    private void getLocation() {
        // Check for permission and request for permission if not available.
        if (ActivityCompat.checkSelfPermission(
                getApplicationContext(),Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
        } else {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5, LocationActivity.this);
        }
    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        location_text = "Latitude: "+ location.getLatitude() + "\nLongitude: " + location.getLongitude();

        display_location_text_view.setText(location_text);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("location", location_text);
    }
}