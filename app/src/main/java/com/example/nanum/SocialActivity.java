package com.example.nanum;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.BaseAdapter;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SocialActivity extends AppCompatActivity {
    SingerAdapter_social adapter;
    Button btnHome, btnChatting, btnPost, btnMypage;
    ScrollView sv;
    ListView listView;


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.social_layout);

        btnHome = (Button) findViewById(R.id.btnHome);
        btnChatting = (Button) findViewById(R.id.btnChatting);
        btnPost = (Button) findViewById(R.id.btnPost);
        btnMypage = (Button) findViewById(R.id.btnMypage);

        sv = (ScrollView) findViewById(R.id.sv01);
        listView = (ListView) findViewById(R.id.listView);


        adapter = new SingerAdapter_social();

        adapter.addItem(new SingerItem_Social("소녀시대", "01071803396", R.drawable.pic));
        adapter.addItem(new SingerItem_Social("소2녀시대", "01071803396", R.drawable.pic));
        adapter.addItem(new SingerItem_Social("소3녀시대", "01071803396", R.drawable.pic));

        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SingerItem item = (SingerItem) adapter.getItem(position);
                Toast.makeText(getApplicationContext(), "선택 :"+item.getName(), Toast.LENGTH_LONG).show();
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( getApplicationContext(), MainmenuActivity.class);
                startActivity(intent);
            }
        });



        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( getApplicationContext(), PostActivity.class);
                startActivity(intent);
            }
        });

    }

    class SingerAdapter_social extends BaseAdapter{
        ArrayList<SingerItem_Social> items = new ArrayList<SingerItem_Social>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(SingerItem_Social item) {
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            // 뷰 객체 재사용
            SingerItemView_Social view = null;
            if (convertView == null) {
                view = new SingerItemView_Social(getApplicationContext());
            } else {
                view = (SingerItemView_Social) convertView;
            }

            SingerItem_Social item = items.get(position);

            view.setName(item.getName());
            view.setMobile(item.getMobile());
            view.setImage(item.getResId());


            return view;
        }
    }


}


