package com.example.lab_06

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_lab06.R

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PatientAdapter
    private val patientList = ArrayList<Patient>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerViewPatients)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Dummy data
        patientList.add(Patient(1, "Иван Иванов", 35, "Грипп", "123456789"))
        patientList.add(Patient(2, "Мария Смирнова", 29, "ОРВИ", "987654321"))

        adapter = PatientAdapter(this, patientList)
        recyclerView.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_add -> {
                patientList.add(Patient(3, "Новый Пациент", 0, "Неизвестно", "000000000"))
                adapter.notifyDataSetChanged()
            }
            R.id.menu_delete -> {
                if (patientList.isNotEmpty()) {
                    patientList.removeAt(patientList.size - 1)
                    adapter.notifyDataSetChanged()
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
