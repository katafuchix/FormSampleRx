package com.example.formsamplerx

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class RegistrationCompleteActivity : AppCompatActivity() {

    companion object {
        fun createIntent(context: Context) = Intent(context, RegistrationCompleteActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration_complete)
    }
}
