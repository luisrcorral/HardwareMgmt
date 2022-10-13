package mx.tec.hardwaremgmt

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class accelerometer : AppCompatActivity(), SensorEventListener  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accelerometer)

        val sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager

        sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)?.also { accelerometer ->
            sensorManager.registerListener(
                this,
                accelerometer,
                SensorManager.SENSOR_DELAY_FASTEST,
                SensorManager.SENSOR_DELAY_FASTEST
            )
        }

    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event?.sensor?.type == Sensor.TYPE_ACCELEROMETER) {

            var ax = event.values[0]
            val ay = event.values[1]
            val az = event.values[2]
            val xValues = findViewById<TextView>(R.id.valueX)
            val yValues = findViewById<TextView>(R.id.valueY)
            val zValues = findViewById<TextView>(R.id.valueZ)
            xValues.text = "" + ax
            yValues.text = "" + ay
            zValues.text = "" + az
        }

    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        return
    }

}

