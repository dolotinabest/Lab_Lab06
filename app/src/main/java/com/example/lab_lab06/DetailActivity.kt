package com.example.lab_06

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.lab_lab06.R

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val patient = intent.getSerializableExtra("patient") as Patient

        val detailTextView = findViewById<TextView>(R.id.textViewDetail)
        detailTextView.text = "Имя: ${patient.name}\nВозраст: ${patient.age}\nДиагноз: ${patient.diagnosis}\nТелефон: ${patient.phoneNumber}"
    }
}
