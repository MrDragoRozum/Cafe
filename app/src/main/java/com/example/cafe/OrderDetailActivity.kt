package com.example.cafe

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cafe.databinding.ActivityOrderDetailBinding
import com.example.cafe.Extra.*
class OrderDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOrderDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_detail)
        binding = ActivityOrderDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    companion object {
        fun newIntent(
            context: Context,
            userName: String,
            drink: String,
            additives: String,
            drinkType: String
        ): Intent {
            val intent = Intent(context, OrderDetailActivity::class.java)
            with(intent) {
                putExtra(EXTRA_USER_NAME.name, userName)
                putExtra(EXTRA_DRINK.name, drink)
                putExtra(EXTRA_ADDITIVES.name, additives)
                putExtra(EXTRA_DRINK_TYPE.name, drinkType)
                return this
            }
        }
    }
}