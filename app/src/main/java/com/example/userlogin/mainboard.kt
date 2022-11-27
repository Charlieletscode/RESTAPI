package com.example.userlogin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class mainboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainboard)
        val next = findViewById<View>(R.id.toProfile) as Button
        next.setOnClickListener {
            Toast.makeText(this, "next", Toast.LENGTH_SHORT).show()
            val intent = Intent(this as Context?, signout::class.java)
            this.startActivity(intent)
        }
        val add = findViewById<View>(R.id.addexpense) as Button
        add.setOnClickListener {
            Toast.makeText(this, "add", Toast.LENGTH_SHORT).show()
            val intent = Intent(this as Context?, add_expense::class.java)
            this.startActivity(intent)
        }
    }
}