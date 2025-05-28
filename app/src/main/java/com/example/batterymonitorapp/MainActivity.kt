package com.example.batterymonitorapp

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var batteryStateReceiver: BatteryStateReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        batteryStateReceiver = BatteryStateReceiver()
        val intentFilter = IntentFilter().apply {
            addAction(Intent.ACTION_POWER_CONNECTED)
            addAction(Intent.ACTION_POWER_DISCONNECTED)
            addAction(Intent.ACTION_BATTERY_LOW)
            addAction(Intent.ACTION_BATTERY_OKAY)
        }
        registerReceiver(batteryStateReceiver, intentFilter)
    }

    override fun onPause() {
        super.onPause()
        if (batteryStateReceiver != null) {
            unregisterReceiver(batteryStateReceiver)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (batteryStateReceiver != null) {
            unregisterReceiver(batteryStateReceiver)

            batteryStateReceiver = null
        }
    }
}