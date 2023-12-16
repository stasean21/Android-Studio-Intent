package com.example.activities_lab_3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class DisplayDataActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_data)

        val name = intent.getStringExtra("name")
        val dob = intent.getStringExtra("dob")

        val textViewName: TextView = findViewById(R.id.textViewName)
        val textViewDOB: TextView = findViewById(R.id.textViewDOB)

        textViewName.text = "Name: $name"
        textViewDOB.text = "Date of Birth: $dob"
    }
}
