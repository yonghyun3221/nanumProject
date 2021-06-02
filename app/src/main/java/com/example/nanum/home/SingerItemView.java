package com.example.nanum.home;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.nanum.R;

public class SingerItemView extends LinearLayout {

    TextView textView;
    TextView textView2;
    TextView keyword1;
    ImageView imageView;

    // Generate > Constructor

    public SingerItemView(Context context) {
        super(context);

        init(context);
    }

    public SingerItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    // singer_item.xml을 inflation
    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.singer_item, this, true);

        textView = (TextView) findViewById(R.id.homeName);
        textView2 = (TextView) findViewById(R.id.homeText);
        imageView = (ImageView) findViewById(R.id.homeImg);
        keyword1 = (TextView) findViewById(R.id.keyword);

        //여기부분 글꼴이나 색상 변집가능한듯
       // textView.setTextColor(Color.BLUE);

        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "font/nanumsquarer.ttf"); // font 폴더내에 있는 jua.ttf 파일을 typeface로 설정
        textView.setTypeface(typeface);
        textView2.setTypeface(typeface);
        keyword1.setTypeface(typeface);

    }

    public void setName(String name) {
        textView.setText(name);
    }

    public void setMobile(String mobile) {
        textView2.setText(mobile);
    }

    public void setImage(int resId) {
        imageView.setImageResource(resId);
    }

    public void setKeyword(String keyword) {
        keyword1.setText(keyword);
    }

}