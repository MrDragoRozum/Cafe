package com.example.cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MakeOrderActivity extends AppCompatActivity {

    private TextView textViewGreetings, textViewAdditives;
    private RadioGroup radioGroupDrinks;
    private RadioButton radioButtonTea, radioButtonCoffee;
    private CheckBox checkboxSugar, checkboxMilk, checkBoxLemon;
    private Spinner spinnerCoffee, spinnerTea;
    private Button buttonMakeOrder;

    static final String EXTRA_USER_NAME = "userName";

    private String userName;
    private String drink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_order);
        initViews();

        setupUserName();

        radioGroupDrinks.setOnCheckedChangeListener((e, id) -> {
            if(radioButtonCoffee.getId() == id) {
                onChoseCoffee();
            } else if(radioButtonTea.getId() == id) {
                onChoseTea();
            }
        });

        radioButtonTea.setChecked(true);

        buttonMakeOrder.setOnClickListener(l -> onUserMakeOrder());
    }

    private void onUserMakeOrder() {
        ArrayList<String> additives = new ArrayList<>();

        if(checkBoxLemon.isChecked() && radioButtonTea.isChecked()) {
            String lemon = checkBoxLemon.getText().toString();
            additives.add(lemon);
        }
        if(checkboxMilk.isChecked()) {
            String milk = checkboxMilk.getText().toString();
            additives.add(milk);
        }
        if(checkboxSugar.isChecked()) {
            String sugar = checkboxSugar.getText().toString();
            additives.add(sugar);
        }

        String drinkType = "";

        if(radioButtonTea.isChecked()) {
            drinkType = spinnerTea.getSelectedItem().toString();
        } else if(radioButtonCoffee.isChecked()) {
            drinkType = spinnerCoffee.getSelectedItem().toString();
        }

        // Избавляемся от угловых скобок у ArrayList.toString()
        String additivesString = additives.toString();
        int length = additivesString.length();
        additivesString = additivesString.substring(1, length -1);

        Intent intent = OrderDetailActivity.newIntent(this,
                userName,
                drink,
                additivesString,
                drinkType);

        startActivity(intent);
    }

    private void onChoseTea() {
        drink = getString(R.string.tea);
        String additives = getString(R.string.additives, drink);
        textViewAdditives.setText(additives);
        checkBoxLemon.setVisibility(View.VISIBLE);
        spinnerTea.setVisibility(View.VISIBLE);
        spinnerCoffee.setVisibility(View.INVISIBLE);
    }

    private void onChoseCoffee() {
        drink = getString(R.string.coffee);
        String additives = getString(R.string.additives, drink);
        textViewAdditives.setText(additives);
        checkBoxLemon.setVisibility(View.INVISIBLE);
        spinnerTea.setVisibility(View.INVISIBLE);
        spinnerCoffee.setVisibility(View.VISIBLE);
    }


    private void setupUserName() {
        userName = getIntent().getStringExtra(EXTRA_USER_NAME);
        String greetings = getString(R.string.greetings, userName);
        textViewGreetings.setText(greetings);
    }

    public static Intent newIntent(Context context, String nameUser) {
        Intent intent = new Intent(context, MakeOrderActivity.class);
        intent.putExtra(EXTRA_USER_NAME, nameUser);
        return intent;
    }

    private void initViews() {
        textViewGreetings = findViewById(R.id.textViewGreetings);
        textViewAdditives = findViewById(R.id.textViewAdditives);

        radioGroupDrinks = findViewById(R.id.radioGroupDrinks);
        radioButtonTea = findViewById(R.id.radioButtonTea);
        radioButtonCoffee = findViewById(R.id.radioButtonCoffee);

        checkBoxLemon = findViewById(R.id.checkBoxLemon);
        checkboxMilk = findViewById(R.id.checkboxMilk);
        checkboxSugar = findViewById(R.id.checkboxSugar);

        spinnerTea = findViewById(R.id.spinnerTea);
        spinnerCoffee = findViewById(R.id.spinnerCoffee);

        buttonMakeOrder = findViewById(R.id.buttonMakeOrder);

    }
}