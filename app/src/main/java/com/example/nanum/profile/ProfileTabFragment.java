package com.example.nanum.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.nanum.R;
import com.example.nanum.login.LoginActivity;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class ProfileTabFragment extends Fragment // Fragment 클래스를 상속받아야한다
{
    GoogleSignInClient mGoogleSignInClient;
    private static final String TAG = "MainActivity";

    private View view;
    TextView text;
    public Button editPro, logout;
    // 마지막으로 뒤로 가기 버튼을 눌렀던 시간 저장
    private long backKeyPressedTime = 0;
    // 첫 번째 뒤로 가기 버튼을 누를 때 표시
    private Toast toast;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.profile_main_layout,container,false);
        editPro = (Button)view.findViewById(R.id.profileEditBtn);
        logout = (Button)view.findViewById(R.id.profileLogoutBtn);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail() // email addresses도 요청함
                .build();

        // 위에서 만든 GoogleSignInOptions을 사용해 GoogleSignInClient 객체를 만듬
        mGoogleSignInClient = GoogleSignIn.getClient(inflater.getContext(), gso);


        editPro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( view.getContext(), EditProfileActivity.class);
                startActivity(intent);
            }
        });

        //앱 공유 코드
    /*    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.shareApp);
        linearLayout.setOnClickListener(new TextView.OnClickListener() {
            public void onClick(View view) {
                Intent msg = new Intent(Intent.ACTION_SEND);

                msg.addCategory(Intent.CATEGORY_DEFAULT);
                msg.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=nanum");
                msg.putExtra(Intent.EXTRA_TITLE, "NANUM");
                msg.setType("text/plain");
                startActivity(Intent.createChooser(msg, "앱을 선택해 주세요"));

            }
        });
        */
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGoogleSignInClient.revokeAccess();
                mGoogleSignInClient.signOut();

                Intent intent = new Intent( view.getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

}