package com.example.intent_tp5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InscriActivity extends AppCompatActivity {
    EditText password, userName, firstName, lastName,phone,email;
    Button register;

    private MonOpenHelper monHelper = null;
    private SQLiteDatabase db = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscri);
        password = findViewById(R.id.password);
        userName = findViewById(R.id.UserName);
        firstName = findViewById(R.id.fisrtName);
        lastName = findViewById(R.id.LastName);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        register = findViewById(R.id.register);

        monHelper = new MonOpenHelper(this);
        db = monHelper.getWritableDatabase();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (password.getText().toString().isEmpty() || email.getText().toString().isEmpty() || phone.getText().toString().isEmpty() ||
                        firstName.getText().toString().isEmpty() || lastName.getText().toString().isEmpty() || userName.getText().toString().isEmpty()){
                    if (password.getText().toString().isEmpty()){
                        Toast.makeText(getApplicationContext(), "password is empty", Toast.LENGTH_SHORT).show();
                    }if (email.getText().toString().isEmpty()){
                        Toast.makeText(getApplicationContext(), "email is empty", Toast.LENGTH_SHORT).show();
                    }if (phone.getText().toString().isEmpty()){
                        Toast.makeText(getApplicationContext(), "phone is empty", Toast.LENGTH_SHORT).show();
                    }if (userName.getText().toString().isEmpty()){
                        Toast.makeText(getApplicationContext(), "Username is empty", Toast.LENGTH_SHORT).show();
                    }if (firstName.getText().toString().isEmpty()){
                        Toast.makeText(getApplicationContext(), "First Name is empty", Toast.LENGTH_SHORT).show();
                    }if (lastName.getText().toString().isEmpty()){
                        Toast.makeText(getApplicationContext(), "Last name is empty", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    ContentValues values = new ContentValues();
                    values.put("EMAIL", email.getText().toString());
                    values.put("FIRSTNAME", firstName.getText().toString());
                    values.put("LASTNAME", lastName.getText().toString());
                    values.put("USERNAME", userName.getText().toString());
                    values.put("PASSWORD", password.getText().toString());
                    values.put("PHONE", phone.getText().toString());

                    long result = db.insert("USERS", null, values);
                    if (result > 0) {
                        Toast.makeText(getApplicationContext(), "line added successfully", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        i.putExtra("username", userName.getText().toString());
                        i.putExtra("password", password.getText().toString());
                        startActivity(i);
                    } else {
                        Toast.makeText(getApplicationContext(), "Failed to register user", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }
}