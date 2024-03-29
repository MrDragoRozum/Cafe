package com.example.cafe

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.cafe.databinding.ActivityMakeOrderBinding

class MakeOrderActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMakeOrderBinding
    private var userName = ""
    private var drink = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_make_order)
        binding = ActivityMakeOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUserName()
        listeners()
        binding.radioButtonTea.isChecked = true
    }

    private fun listeners() {
        with(binding) {
            radioGroupDrinks.setOnCheckedChangeListener { _, id ->
                if (radioButtonCoffee.id == id) {
                    onChoseCoffee()
                } else if (radioButtonTea.id == id) {
                    onChoseTea()
                }
            }
            buttonMakeOrder.setOnClickListener { onUserMakeOrder() }
        }
    }

    private fun onUserMakeOrder() {
        val additives = mutableListOf<String>()
        with(binding) {

            if (checkBoxLemon.isChecked && radioButtonTea.isChecked) {
                val lemon = checkBoxLemon.text.toString()
                additives.add(lemon)
            }
            if (checkboxMilk.isChecked) {
                val milk = checkboxMilk.text.toString()
                additives.add(milk)
            }
            if (checkboxSugar.isChecked) {
                val sugar = checkboxSugar.text.toString()
                additives.add(sugar)
            }

            val drinkType = if (radioButtonTea.isChecked)
                spinnerTea.selectedItem.toString()
            else spinnerCoffee.selectedItem.toString()

            val intent = OrderDetailActivity.newIntent(
                this@MakeOrderActivity,
                userName,
                drink,
                additives.toString(),
                drinkType
            )
            startActivity(intent)
        }
    }

    private fun onChoseTea() {
        with(binding) {
            drink = getString(R.string.tea)
            val additives = getString(R.string.additives, drink)
            textViewAdditives.text = additives
            checkBoxLemon.visibility = View.VISIBLE
            spinnerTea.visibility = View.VISIBLE
            spinnerCoffee.visibility = View.INVISIBLE
        }
    }

    private fun onChoseCoffee() {
        with(binding) {
            drink = getString(R.string.coffee)
            val additives = getString(R.string.additives, drink)
            textViewAdditives.text = additives
            checkBoxLemon.visibility = View.INVISIBLE
            spinnerTea.visibility = View.INVISIBLE
            spinnerCoffee.visibility = View.VISIBLE
        }
    }

    private fun setupUserName() {
        intent.getStringExtra(Extra.EXTRA_USER_NAME.name)?.let {
            userName = it
            binding.textViewGreetings.text = getString(R.string.greetings, it)
        }
    }

    companion object {
        fun newIntent(context: Context, nameUser: String): Intent {
            val intent = Intent(context, MakeOrderActivity::class.java)
            intent.putExtra(Extra.EXTRA_USER_NAME.name, nameUser)
            return intent
        }
    }
}