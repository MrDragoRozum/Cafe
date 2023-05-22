package com.example.cafe

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MakeOrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_make_order)
    }

    companion object {
        const val EXTRA_USER_NAME = "userName"
        fun newIntent(context: Context, nameUser: String): Intent {
            val intent = Intent(context, Companion::class.java)
            intent.putExtra(EXTRA_USER_NAME, nameUser)
            return intent
        }
    }
}