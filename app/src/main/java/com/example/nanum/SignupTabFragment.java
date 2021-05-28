package com.example.nanum;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainer;

public class SignupTabFragment extends Fragment {
    EditText semail, spw, name, spwcheck;
    Button signup;
    String spw_s, spwcheck_s;

    private  Context context;

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

        Activity mActivity = this.getActivity();


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spw_s = spw.getText().toString();
                spwcheck_s = spwcheck.getText().toString();



                if (spw_s.equals(spwcheck_s)){
                    //toast test
                    Toast toast = Toast.makeText(
                            //getActivity(),"Custom Toast From Fragment",Toast.LENGTH_LONG
                            getActivity().getApplicationContext(), "Custom Toast From Fragment", Toast.LENGTH_LONG
                    );
                    // Set the Toast display position layout center
                    toast.setGravity(Gravity.CENTER,0,0);
                    // Finally, show the toast
                    toast.show();

                    Toast.makeText(mActivity,"Text you want to display",Toast.LENGTH_SHORT).show();
                    context = container.getContext();
                    Toast.makeText(context, "이것은 Toast 메시지입니다.", Toast.LENGTH_SHORT).show();
                    Toast.makeText(SignupTabFragment.super.getActivity(),"Toast Message",Toast.LENGTH_SHORT).show();
                    Toast.makeText(root.getContext(), "tost", Toast.LENGTH_SHORT).show();
                    Toast.makeText(getActivity(),"Text!33333",Toast.LENGTH_SHORT).show();
                    Toast.makeText(SignupTabFragment.this.getContext(), "Text!1111",Toast.LENGTH_SHORT).show();
                    Toast.makeText(SignupTabFragment.this.getActivity(), "Text!22222",Toast.LENGTH_SHORT).show();
                    Toast.makeText(root.getContext().getApplicationContext(), "texttttttt", Toast.LENGTH_LONG).show();

                    name.setText("성공");


                    Intent intent = new Intent(getActivity().getApplicationContext(), LoginActivity.class);
                    //startActivity(intent);
                }


            }
        });

        return root;
    }
}
