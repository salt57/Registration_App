package com.sourishgupta.registrationapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupSpinner()

        button_register.setOnClickListener {
            onClickRegister()
        }
    }

    private fun onClickRegister() {
        val details = Details(
            spinner_title.selectedItem?.toString(),
            edit_text_first_name.text.toString(),
            edit_text_last_name.text.toString(),
            edit_text_email.text.toString(),
            edit_text_phone.text.toString(),
            edit_text_password.text.toString()
        )

        val intent = Intent(this, SummaryActivity::class.java)
        intent.putExtra("Details", details)

        startActivity(intent)
    }

    private fun setupSpinner() {
        val spinnerValues = arrayOf("Mr.", "Mrs.", "Ms.")
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, spinnerValues)
        spinner_title.adapter = spinnerAdapter
    }
}