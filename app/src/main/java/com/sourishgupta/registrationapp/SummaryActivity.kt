package com.sourishgupta.registrationapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import kotlinx.android.synthetic.main.activity_summary.*

class SummaryActivity : AppCompatActivity() {

    private lateinit var details: Details;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        displaySummary()
        setupClickables()
    }

    private fun setupClickables() {
        text_view_email.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:${details.email}")
            }

            startActivity(emailIntent)
        }

        text_view_phone.setOnClickListener {
            val phoneIntent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:${details.phone}")
            }

            startActivity(phoneIntent)
        }
    }

    private fun displaySummary() {
        details = intent.getSerializableExtra("Details") as Details
        text_view_summary_text.text =
            "You have successfully been registered ${details.title} ${details.lastName}"
        text_view_email.text = "Your email id is : ${details.email}"
        text_view_phone.text = "Your phone number is : ${details.phone}"
        text_view_password.text = "Your password is : ${details.password}"
    }
}