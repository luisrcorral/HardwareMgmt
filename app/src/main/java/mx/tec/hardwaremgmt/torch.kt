package mx.tec.hardwaremgmt

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.hardware.camera2.CameraAccessException
import android.hardware.camera2.CameraManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi

class torch : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_torch)

        var cameraManager = getSystemService(CAMERA_SERVICE) as CameraManager
        var cameraId = cameraManager.cameraIdList[1] as String

        var buttonOn = findViewById(R.id.button_on) as Button
        var buttonOff = findViewById(R.id.button_off) as Button


        buttonOn.setOnClickListener {
            cameraManager.setTorchMode(cameraId, true)
            Toast.makeText(this,"Light on",Toast.LENGTH_SHORT).show()
        }

        buttonOff.setOnClickListener {
            cameraManager.setTorchMode(cameraId, false)
            Toast.makeText(this,"Light off",Toast.LENGTH_SHORT).show()
        }
    }
}