package mx.tec.hardwaremgmt

import android.content.Context
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class proximity : AppCompatActivity(), SensorEventListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_proximity)

        val sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        
        sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)?.also { proximity ->
            sensorManager.registerListener(
                this,
                proximity,
                SensorManager.SENSOR_DELAY_FASTEST,
                SensorManager.SENSOR_DELAY_FASTEST
            )
        }

    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event?.sensor?.type == Sensor.TYPE_PROXIMITY) {
            // Detected something nearby
            if(event.values[0] == 0f) {
                getWindow().getDecorView().setBackgroundColor(Color.RED)
            } else {
                // Nothing is nearby
                getWindow().getDecorView().setBackgroundColor(Color.GREEN)
            }

        }

    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        return
    }

}