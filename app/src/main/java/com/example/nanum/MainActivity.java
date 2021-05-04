package com.example.nanum;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

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


                System.out.println("onclick");




                new Thread(){

                    @Override
                    public void run() {

                        System.out.println("runThread");

                        try {
                            System.out.println("run");

                            URL url = new URL("http://116.39.48.151:3000/users");
                            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                            connection.setRequestMethod("GET"); //전송방식
                            connection.setDoOutput(false);       //데이터를 쓸 지 설정
                            connection.setDoInput(true);        //데이터를 읽어올지 설정

                            InputStream is = connection.getInputStream();
                            StringBuilder sb = new StringBuilder();
                            BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
                            String result;
                            int count = 0;
                            while((result = br.readLine())!=null){
                                count++;
                                System.out.println("br = ");
                                System.out.println(count);

                                sb.append(result+"\n");
                            }

                            System.out.println(sb);


                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();

            }
        });


        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent);

            }
        });





    }
}