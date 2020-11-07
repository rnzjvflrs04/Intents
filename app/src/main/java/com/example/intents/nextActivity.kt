package com.example.intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.Settings
import android.widget.Button
import android.widget.Toast

class nextActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

        findViewById<Button>(R.id.calendarBtn).setOnClickListener { showCalendar() }
        findViewById<Button>(R.id.wifiBtn).setOnClickListener { showWifi() }
        findViewById<Button>(R.id.messagesBtn).setOnClickListener { showMessages() }
        findViewById<Button>(R.id.settingsBtn).setOnClickListener { showSettings() }
        findViewById<Button>(R.id.alarmBtn).setOnClickListener { showAlarm() }
    }

    private fun showCalendar(){
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_APP_CALENDAR)
        startActivity(intent)
    }

    private fun showWifi(){
        val intent = Intent(Settings.ACTION_WIFI_SETTINGS)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    private fun showMessages(){
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_APP_MESSAGING)
        startActivity(intent)
    }

    private fun showSettings(){
        val intent = Intent(Settings.ACTION_SETTINGS)
        intent.addCategory(Intent.ACTION_ALL_APPS) //The intent failed due to wrong category
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this, "Cannot open SETTINGS.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showAlarm(){
        val intent = Intent(AlarmClock.ACTION_SET_ALARM)
        intent.addCategory(Intent.CATEGORY_APP_CONTACTS) //The intent failed due to CATEGORY_APP_CONTACTS is not present in ACTION_SET_ALARM
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this, "Cannot open clock.", Toast.LENGTH_SHORT).show()
        }
    }
}