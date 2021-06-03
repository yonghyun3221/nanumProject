package com.example.nanum.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.example.nanum.MainActivity;
import com.example.nanum.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class LoginTabFragment extends Fragment {
    Context context;
    EditText email, passwd;
    Button login;
    String text;
    String email_s;
    String passwd_s;

    float v = 0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_tab_fragment, container, false);

        email = root.findViewById(R.id.loginEmail);
        passwd = root.findViewById(R.id.logInPasswd);
        login = (Button)root.findViewById(R.id.loginBtn);


        email.setTranslationX(800);
        passwd.setTranslationX(800);
        login.setTranslationX(800);

        email.setAlpha(v);
        passwd.setAlpha(v);
        login.setAlpha(v);

        email.animate().translationX(0).alpha(1).setDuration(800).setDuration(300).start();
        passwd.animate().translationX(0).alpha(1).setDuration(800).setDuration(500).start();
        login.animate().translationX(0).alpha(1).setDuration(800).setDuration(700).start();

        email.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey (View v,int KeyCode, KeyEvent event){
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && KeyCode == KeyEvent.KEYCODE_ENTER) {
                    passwd.requestFocus();
                    return true;
                }
                return false;
            }
        });
        passwd.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey (View v,int KeyCode, KeyEvent event){
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && KeyCode == KeyEvent.KEYCODE_ENTER) {
                    login.performClick();
                    return true;
                }
                return false;
            }
        });






        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //if (check()) //check(emailText, pwText) )
                {
                    email_s = email.getText().toString();
                    passwd_s = passwd.getText().toString();
                    System.out.println("test id pw : " + email_s + " , " + passwd_s);


                    Intent intent = new Intent(getActivity().getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            }
        });









        return root;
    }



    boolean check(){


        text = email.getText().toString();

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



        return true;
    }

}
