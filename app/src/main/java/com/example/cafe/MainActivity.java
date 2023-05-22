//package com.example.cafe;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.annotation.SuppressLint;
//import android.content.Intent;
//import android.os.Bundle;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ScrollView;
//import android.widget.Toast;
//
//public class MainActivity extends AppCompatActivity {
//
//    private EditText editTextName;
//    private EditText editTextPassword;
//    private Button buttonSignIn;
//    private ScrollView scrollView;
//
//    @SuppressLint("ClickableViewAccessibility")
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        initView();
//
//        scrollView.setOnTouchListener((v, event) -> true);
//
//        buttonSignIn.setOnClickListener(l -> {
//            String nameUser = editTextName.getText().toString().trim();
//            String namePassword = editTextPassword.getText().toString().trim();
//
//            if(!(nameUser.isEmpty() || namePassword.isEmpty())) {
//                launchNextScreen(nameUser);
//            } else {
//                Toast.makeText(this,
//                        R.string.error_field_empty,
//                        Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//    private void launchNextScreen(String nameUser) {
//        Intent intent = MakeOrderActivity.newIntent(this, nameUser);
//        startActivity(intent);
//    }
//
//    private void initView() {
//        scrollView = findViewById(R.id.scrollView);
//        editTextPassword = findViewById(R.id.editTextPassword);
//        buttonSignIn = findViewById(R.id.buttonSignIn);
//        editTextName = findViewById(R.id.editTextName);
//    }
//
//
//}