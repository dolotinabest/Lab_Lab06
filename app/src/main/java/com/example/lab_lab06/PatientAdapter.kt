package com.example.lab_06

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_lab06.R

class PatientAdapter(
    private val context: Context,
    private val patientList: ArrayList<Patient>
) : RecyclerView.Adapter<PatientAdapter.PatientViewHolder>() {

    inner class PatientViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.textViewName)
        val ageTextView: TextView = itemView.findViewById(R.id.textViewAge)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra("patient", patientList[position])
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PatientViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_patient, parent, false)
        return PatientViewHolder(view)
    }

    override fun onBindViewHolder(holder: PatientViewHolder, position: Int) {
        val patient = patientList[position]
        holder.nameTextView.text = patient.name
        holder.ageTextView.text = "Age: ${patient.age}"
    }

    override fun getItemCount(): Int = patientList.size
}
