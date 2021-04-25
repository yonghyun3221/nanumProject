package com.example.nanum;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView mainImage;
    Button signInBtn, signUpBtn;
    EditText emailText, pwText;


    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainImage = (ImageView)findViewById(R.id.imageView3);
        signInBtn = (Button)findViewById(R.id.SignInBtn);
        signUpBtn = (Button)findViewById(R.id.SignUpBtn);
        emailText = (EditText)findViewById(R.id.EmailTextField);
        pwText = (EditText) findViewById(R.id.PWTextField);

        mainImage.setVisibility(View.VISIBLE);
        mainImage.setImageResource(R.drawable.pic);

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = emailText.getText().toString();
                Toast.makeText(getApplicationContext(),text, Toast.LENGTH_LONG).show();
            }
        });

    }
}