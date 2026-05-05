package com.example.profileapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.profileapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEdit.setOnClickListener {
            val intent = Intent(this, EditProfileActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()

        val prefs = getSharedPreferences("PROFILE", MODE_PRIVATE)

        binding.tvName.text = prefs.getString("name", "Name")
        binding.tvEmail.text = prefs.getString("email", "Email")
        binding.tvBio.text = prefs.getString("bio", "Bio")
    }
}