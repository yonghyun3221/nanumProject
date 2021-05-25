package com.example.nanum;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class SignupTabFragment extends Fragment {
    EditText semail, spw, name, spwcheck;
    Button signup;

    float v=0;
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.signup_tab_fragment, container, false);

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

        return root;
    }
}
