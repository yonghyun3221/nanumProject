package com.example.nanum.chat;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;

import com.example.nanum.R;

public class ChattingPostView extends LinearLayout {

    TextView textView;
    TextView textView2;
    ImageView imageView;

    // Generate > Constructor

    public ChattingPostView(Context context) {
        super(context);

        init(context);
    }

    public ChattingPostView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    // singer_item.xml을 inflation
    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.chatting_post_item, this, true);

        textView = (TextView) findViewById(R.id.chatPostName);
        textView2 = (TextView) findViewById(R.id.chatPostText);
        imageView = (ImageView) findViewById(R.id.chatPostImg);


        Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), "font/nanumsquarer.ttf"); // font 폴더내에 있는 jua.ttf 파일을 typeface로 설정
        textView.setTypeface(typeface);
        textView2.setTypeface(typeface);

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

}