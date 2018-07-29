package com.example.xyd93.amjumpstart

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.VibrationEffect
import android.widget.Toast
import android.os.Vibrator
import android.support.v4.content.ContextCompat.getSystemService

class SystemAlarm: BroadcastReceiver(){

    override fun onReceive(p0: Context?, p1: Intent?) {
        Toast.makeText(p0, "Alarm!", Toast.LENGTH_LONG).show()
//        val vibrator = getSystemService(Context.VIBRATOR_SERVICE)
        val vibrator = p0?.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

        val pattern = longArrayOf(0, 100, 1000)
//        val vibrationEffect = VibrationEffect
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator.vibrate(VibrationEffect.createWaveform(pattern, 0))
        }else{
            //deprecated in API 26
            vibrator.vibrate(500)
        }
    }
}