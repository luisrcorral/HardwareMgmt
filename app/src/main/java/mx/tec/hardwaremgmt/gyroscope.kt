package mx.tec.hardwaremgmt

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class gyroscope : AppCompatActivity(), SensorEventListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gyroscope)

      val sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager

      sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)?.also { accelerometer ->
            sensorManager.registerListener(
                this,
                accelerometer,
                SensorManager.SENSOR_DELAY_FASTEST,
                SensorManager.SENSOR_DELAY_FASTEST
            )
        }
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event?.sensor?.type == Sensor.TYPE_GYROSCOPE) {

            var yaw = event.values[0]
            var pitch = event.values[1]
            var roll = event.values[2]

            val yawValues = findViewById<TextView>(R.id.valueYaw)
            val pitchValues = findViewById<TextView>(R.id.valuePitch)
            val rollValues = findViewById<TextView>(R.id.valueRoll)
            yawValues.text = "" + yaw
            pitchValues.text = "" + pitch
            rollValues.text = "" + roll
        }

    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        return
    }
}