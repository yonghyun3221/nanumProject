package com.example.nanum;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.nanum.login.LoginActivity;

public class SignupTabFragment extends Fragment {
    EditText semail, spw, name, spwcheck;
    Button signup;
    String spw_s, spwcheck_s;

    private  Context context;

    float v=0;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.signup_tab_fragment, container, false);

        //Toast.makeText(this.getActivity(), "hello from fragment", Toast.LENGTH_LONG).show();

        semail= root.findViewById(R.id.semail);
        spw = root.findViewById(R.id.spw);
        spwcheck = root.findViewById(R.id.pwcheck);
        name = root.findViewById(R.id.name);
        signup = root.findViewById(R.id.signup);



        semail.setTranslationX(800);
        spw.setTranslationX(800);
        spwcheck.setTranslationX(800);
        name.setTranslationX(800);
        signup.setTranslationX(800);

        semail.setAlpha(v);
        spw.setAlpha(v);
        spwcheck.setAlpha(v);
        name.setAlpha(v);
        signup.setAlpha(v);

        semail.animate().translationX(0).alpha(1).setDuration(800).setDuration(300).start();
        spw.animate().translationX(0).alpha(1).setDuration(800).setDuration(500).start();
        spwcheck.animate().translationX(0).alpha(1).setDuration(800).setDuration(700).start();
        name.animate().translationX(0).alpha(1).setDuration(800).setDuration(900).start();
        signup.animate().translationX(0).alpha(1).setDuration(800).setDuration(1100).start();

        Activity mActivity = this.getActivity();


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spw_s = spw.getText().toString();
                spwcheck_s = spwcheck.getText().toString();



                if (spw_s.equals(spwcheck_s)){

                    Toast.makeText(getActivity(), "회원가입성공", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getActivity().getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                }


            }
        });

        return root;
    }
}