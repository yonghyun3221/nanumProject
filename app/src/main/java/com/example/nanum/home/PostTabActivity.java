package com.example.nanum.home;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.nanum.MainActivity;
import com.example.nanum.R;

import java.io.InputStream;

public class PostTabActivity extends AppCompatActivity
{
    ImageView postImg;
    Button postBtn, imgBtn;
    EditText textPost;
    //User user = ((User)getApplicationContext());
    String userID;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_post_layout);

        postImg = (ImageView) findViewById(R.id.homePostImage);
        imgBtn = (Button) findViewById(R.id.homePostPhoto);
        postBtn = (Button) findViewById(R.id.homePostSubmit);
        textPost = (EditText) findViewById(R.id.homePostText);

        imgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                //intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true); 여러개 사진 추가할떄


                startActivityForResult(intent, 1);

                postImg.setImageResource(R.drawable.and1);

            }
        });

        postBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("main 유저아이디 : " + userID);
               // Toast.makeText(new AppCompatActivity(), "이건?" + userID, Toast.LENGTH_LONG).show();
               // Log.d("check", userID);
                Intent intent = new Intent( getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                try {
                    // 선택한 이미지에서 비트맵 생성
                    InputStream in = getContentResolver().openInputStream(data.getData());
                    Bitmap img = BitmapFactory.decodeStream(in);
                    in.close();
                    // 이미지 표시
                    postImg.setImageBitmap(img);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}