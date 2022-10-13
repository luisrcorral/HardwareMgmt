package mx.tec.hardwaremgmt

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class gps : AppCompatActivity(), LocationListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gps)

        var locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager

        // Beware of hot permission requesting
        if ((ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 2)
        }

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5f, this)

    }

    override fun onLocationChanged(location: Location) {
        var txtLoc = findViewById<TextView>(R.id.textViewLoc) as TextView
        txtLoc.text = "Latitude: " + location.latitude + " , Longitude: " + location.longitude

    }


}