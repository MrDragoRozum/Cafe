package com.example.cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MakeOrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_order);
    }

    public static Intent newIntent(Context context, String nameUser) {
        Intent intent = new Intent(context, MakeOrderActivity.class);
        intent.putExtra("nameUser", nameUser);
        return intent;
    }
}