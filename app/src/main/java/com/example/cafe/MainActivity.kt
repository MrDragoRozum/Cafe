package com.example.cafe

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cafe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listener()
    }

    private fun listener() {
        binding.buttonSignIn.setOnClickListener {
            val nameUser = binding.editTextName.text.toString().trim()
            val namePassword = binding.editTextPassword.text.toString().trim()

            if (nameUser.isNotEmpty() && namePassword.isNotEmpty()) {
                launchNextScreen(nameUser)
            } else {
                Toast.makeText(this, R.string.error_field_empty, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun launchNextScreen(nameUser: String) {
        val intent = MakeOrderActivity.newIntent(this, nameUser)
        startActivity(intent)
    }
}