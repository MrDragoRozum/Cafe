//package com.example.cafe;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Context;
//import android.content.Intent;
//import android.os.Bundle;
//import android.widget.TextView;
//
//
//public class OrderDetailActivity extends AppCompatActivity {
//
//    private static final String EXTRA_DRINK = "drink";
//    private static final String EXTRA_ADDITIVES = "additives";
//    private static final String EXTRA_DRINK_TYPE = "drinkType";
//
//    private TextView textViewName;
//    private TextView textViewDrinks;
//    private TextView textViewDrinkType;
//    private TextView textViewAdditives;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_order_detail);
//        initView();
//        setupOrder();
//    }
//
//    private void setupOrder() {
//        String drink, additives, drinkType, userName;
//
//        drink = getIntent().getStringExtra(EXTRA_DRINK);
//        additives = getIntent().getStringExtra(EXTRA_ADDITIVES);
//        drinkType = getIntent().getStringExtra(EXTRA_DRINK_TYPE);
//        userName = getIntent().getStringExtra(MakeOrderActivity.EXTRA_USER_NAME);
//
//        textViewName.setText(userName);
//        textViewDrinks.setText(drink);
//        textViewDrinkType.setText(drinkType);
//        textViewAdditives.setText(additives);
//    }
//
//    public static Intent newIntent(Context context,
//                                   String userName,
//                                   String drink,
//                                   String additives,
//                                   String drinkType) {
//
//        Intent intent = new Intent(context, OrderDetailActivity.class);
//        intent.putExtra(MakeOrderActivity.EXTRA_USER_NAME, userName);
//        intent.putExtra(EXTRA_DRINK, drink);
//        intent.putExtra(EXTRA_ADDITIVES, additives);
//        intent.putExtra(EXTRA_DRINK_TYPE, drinkType);
//
//        return intent;
//    }
//
//    private void initView() {
//        textViewDrinks = findViewById(R.id.textViewDrinks);
//        textViewDrinkType = findViewById(R.id.textViewDrinkType);
//        textViewName = findViewById(R.id.textViewName);
//        textViewAdditives = findViewById(R.id.textViewAdditives);
//    }
//}
