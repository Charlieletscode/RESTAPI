package com.example.userlogin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class add_expense : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_expense)
        val next = findViewById<View>(R.id.submit_button) as Button
        next.setOnClickListener {
            Toast.makeText(this, "next", Toast.LENGTH_SHORT).show()
            val intent = Intent(this as Context?, mainboard::class.java)
            this.startActivity(intent)
        }
        val scan = findViewById<View>(R.id.scan) as Button
        scan.setOnClickListener {
            Toast.makeText(this, "scan", Toast.LENGTH_SHORT).show()
            val intent = Intent(this as Context?, Barscanner::class.java)
            this.startActivity(intent)
        }
    }
}