package mx.tec.hardwaremgmt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAcc = findViewById<Button>(R.id.button_acc)
        btnAcc.setOnClickListener {
            val intent = Intent(this, accelerometer::class.java)
            startActivity(intent)
        }

        val btnGps = findViewById<Button>(R.id.buttonGPS)
        btnGps.setOnClickListener {
            val intent = Intent(this, gps::class.java)
            startActivity(intent)
        }

        val btnGyr = findViewById<Button>(R.id.button_gyr)
        btnGyr.setOnClickListener {
            val intent = Intent(this, gyroscope::class.java)
            startActivity(intent)
        }

        val btnPro = findViewById<Button>(R.id.button_pro)
        btnPro.setOnClickListener {
            val intent = Intent(this, proximity::class.java)
            startActivity(intent)
        }

        val btnTor = findViewById<Button>(R.id.button_tor)
        btnTor.setOnClickListener {
            val intent = Intent(this, torch::class.java)
            startActivity(intent)
        }

        val btnVib = findViewById<Button>(R.id.button_vib)
        btnVib.setOnClickListener {
            val intent = Intent(this, vibration::class.java)
            startActivity(intent)
        }




    }
}