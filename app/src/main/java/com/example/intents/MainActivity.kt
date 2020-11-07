package com.example.intents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.loginBtn).setOnClickListener {
            val user = findViewById<EditText>(R.id.usernameTxt)
            val username = user.text.toString();

            val pass = findViewById<EditText>(R.id.passwordTxt)
            val password = pass.text.toString();

            if (username.equals("admin") && password.equals("1234")) {
                login()
            } else {
                Toast.makeText(this, "Incorrect username or password.", Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun login() {
        val intent = Intent(this, nextActivity::class.java)
        startActivity(intent)
        Toast.makeText(this, "You are now logged in", Toast.LENGTH_SHORT).show()
    }
}