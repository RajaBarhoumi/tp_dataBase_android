package com.example.intent_tp5;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView registerTV, contact;
EditText username, password;
Button button;
    private MonOpenHelper monHelper = null;
    private SQLiteDatabase db = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerTV = findViewById(R.id.registerTV);
        username = findViewById(R.id.username);
        password = findViewById(R.id.pwd);
        username.setText(getIntent().getStringExtra("username"));
        password.setText(getIntent().getStringExtra("password"));
        contact = findViewById(R.id.contact);
        button = findViewById(R.id.button);


        monHelper = new MonOpenHelper(this);
        db = monHelper.getReadableDatabase();

registerTV.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i = new Intent(getApplicationContext(),InscriActivity.class);
        startActivity(i);
    }
});

contact.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i = new Intent(getApplicationContext(),ConatctActivity.class);
        startActivity(i);
    }
});

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = username.getText().toString();
                String Password = password.getText().toString();

                if (userName.isEmpty() || Password.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter username and password", Toast.LENGTH_SHORT).show();
                } else {
                    String[] columns = {"USERNAME", "FIRSTNAME"};
                    String selection = "USERNAME=? AND PASSWORD=?";
                    String[] selectionArgs = {userName, Password};
                    Cursor c = db.query("USERS", columns, selection, selectionArgs, null, null, null);

                    if (c.moveToFirst()) {
                        String welcomeMessage = "Welcome " + userName;

                        Intent i = new Intent(getApplicationContext(), WelcomeActivity.class);
                        i.putExtra("welcomeMessage", welcomeMessage);
                        startActivity(i);
                    } else {
                        Toast.makeText(getApplicationContext(), "No such account", Toast.LENGTH_SHORT).show();
                    }
                    c.close();
                }
            }
        });

    }
    /*
    public void register (View v){
        Intent i = new Intent(this,InscriActivity.class);
        startActivity(i);
    }
    */

}