package mx.tec.hardwaremgmt

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import android.widget.Toast

class vibration : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vibration)

        val vibration = (getSystemService(Context.VIBRATOR_SERVICE) as Vibrator)

        // Ask first, act then!
        if (vibration.hasVibrator())
           vibration.vibrate(500)
        else
           Toast.makeText(this,"Your device does not feature a vibrator", Toast.LENGTH_SHORT).show()



    }
}