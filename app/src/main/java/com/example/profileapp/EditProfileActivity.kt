package com.example.profileapp

import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import com.example.profileapp.databinding.ActivityEditProfileBinding

class EditProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            val name = binding.etName.text.toString()
            val email = binding.etEmail.text.toString()
            val bio = binding.etBio.text.toString()

            // VALIDATION
            if (name.isBlank()) {
                binding.etName.error = "Name required"
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.etEmail.error = "Invalid email"
                return@setOnClickListener
            }

            // Save data using SharedPreferences
            val prefs = getSharedPreferences("PROFILE", MODE_PRIVATE)
            prefs.edit().apply {
                putString("name", name)
                putString("email", email)
                putString("bio", bio)
                apply()
            }

            finish() // go back to Profile screen
        }
    }
}