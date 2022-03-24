package com.example.myapplication

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity() {
    private var mSensorManager: SensorManager? = null
    private var mAcelerometro: Sensor? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_fragment)

        //acelerometro = SensorClass(this, Sensor.TYPE_ACCELEROMETER,this)
        mSensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        mAcelerometro = mSensorManager?.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

    }

    override fun onResume() {
        super.onResume()
        mSensorManager?.registerListener(AceletrometroSensor(), mAcelerometro, SensorManager.SENSOR_DELAY_UI)
    }

    override fun onPause() {
        super.onPause()
        mSensorManager?.unregisterListener(AceletrometroSensor())
    }

    internal inner class AceletrometroSensor : SensorEventListener {
        override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {}

        override fun onSensorChanged(event: SensorEvent) {
            val x = event.values[0]
            val y = event.values[1]
            val z = event.values[2]

            Log.i("SENSOR_ACELEROMETRO", "VALOR DO SENSOR = " + x + " " + y + " " + z)

            val acelerometroX = mAcelerometro.toString()
            val acelerometroY = mAcelerometro.toString()
            val  acelerometroZ=   mAcelerometro.toString()


        }
    }




    }

