package com.example.batterymonitorapp


import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BatteryStateReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val action = intent.action

        when (action) {
            Intent.ACTION_BATTERY_LOW -> {
                Toast.makeText(context, "Battery low!", Toast.LENGTH_LONG).show()
            }
            Intent.ACTION_BATTERY_OKAY -> {
                Toast.makeText(context, "Battery OK.", Toast.LENGTH_LONG).show()
            }
            Intent.ACTION_POWER_CONNECTED -> {
                Toast.makeText(context, "Power connected.", Toast.LENGTH_LONG).show()
            }
            Intent.ACTION_POWER_DISCONNECTED -> {
                Toast.makeText(context, "Power disconnected.", Toast.LENGTH_LONG).show()
            }
        }
    }
}