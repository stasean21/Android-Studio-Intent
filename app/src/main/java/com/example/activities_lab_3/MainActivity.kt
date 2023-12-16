package com.example.activities_lab_3

import android.content.Intent
import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar
import android.widget.EditText


class MainActivity : AppCompatActivity() {

    private lateinit var btnPickDate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPickDate = findViewById(R.id.btnPickDate)

        btnPickDate.setOnClickListener {
            showDatePickerDialog()
        }

        val btnSubmit: Button = findViewById(R.id.btnSubmit)

        btnSubmit.setOnClickListener {
            val name = findViewById<EditText>(R.id.editTextName).text.toString()
            val dob = findViewById<EditText>(R.id.editTextDOB).text.toString()

            val intent = Intent(this, DisplayDataActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("dob", dob)

            startActivity(intent)
        }
    }

    private fun showDatePickerDialog() {
        val currentDate = Calendar.getInstance()
        val year = currentDate.get(Calendar.YEAR)
        val month = currentDate.get(Calendar.MONTH)
        val day = currentDate.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view: DatePicker, year: Int, monthOfYear: Int, dayOfMonth: Int ->
                val selectedDate = "$dayOfMonth/${monthOfYear + 1}/$year"
                findViewById<EditText>(R.id.editTextDOB).setText(selectedDate)
            },
            year,
            month,
            day
        )

        datePickerDialog.show()
    }
}

