package com.example.nanum.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nanum.R;
import com.google.android.material.tabs.TabLayout;

public class EditProfileActivity extends AppCompatActivity {
    ImageButton back;
    EditText email, passwd, passwdCheck, name, phone, location;
    Button edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_profile_layout);
        back= (ImageButton) findViewById(R.id.backButton);
        email = (EditText) findViewById(R.id.editProEmail);
        passwd = (EditText) findViewById(R.id.EditProPW);
        passwdCheck = (EditText) findViewById(R.id.editProPWCheck);
        name = (EditText) findViewById(R.id.editProName);
        phone = (EditText) findViewById(R.id.editProPhone);
        location = (EditText) findViewById(R.id.editProLocation);
        edit = (Button) findViewById(R.id.editProModify);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

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
                    passwdCheck.requestFocus();
                    return true;
                }
                return false;
            }
        });
        passwdCheck.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey (View v,int KeyCode, KeyEvent event){
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && KeyCode == KeyEvent.KEYCODE_ENTER) {
                    name.requestFocus();
                    return true;
                }
                return false;
            }
        });
        name.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey (View v,int KeyCode, KeyEvent event){
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && KeyCode == KeyEvent.KEYCODE_ENTER) {
                    phone.requestFocus();
                    return true;
                }
                return false;
            }
        });

        phone.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey (View v,int KeyCode, KeyEvent event){
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && KeyCode == KeyEvent.KEYCODE_ENTER) {
                    location.requestFocus();
                    return true;
                }
                return false;
            }
        });
        location.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey (View v,int KeyCode, KeyEvent event){
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && KeyCode == KeyEvent.KEYCODE_ENTER) {
                    edit.performClick();
                    return true;
                }
                return false;
            }
        });
    }
}
