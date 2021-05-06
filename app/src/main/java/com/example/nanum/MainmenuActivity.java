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

public class MainmenuActivity extends AppCompatActivity {
    SingerAdapter adapter;
    Button btnHome, btnChatting, btnPost, btnMypage;
    ScrollView sv;
    ListView listView;


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenu_layout);

        btnHome = (Button) findViewById(R.id.btnHome);
        btnChatting = (Button) findViewById(R.id.btnChatting);
        btnPost = (Button) findViewById(R.id.btnPost);
        btnMypage = (Button) findViewById(R.id.btnMypage);

        sv = (ScrollView) findViewById(R.id.sv01);
        listView = (ListView) findViewById(R.id.listView);


        adapter = new SingerAdapter();

        adapter.addItem(new SingerItem("소녀시대", "01071803396", R.drawable.pic));
        adapter.addItem(new SingerItem("유용현", "01071803396", R.drawable.pic));

        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SingerItem item = (SingerItem) adapter.getItem(position);
                Toast.makeText(getApplicationContext(), "선택 :"+item.getName(), Toast.LENGTH_LONG).show();
            }
        });



        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent( getApplicationContext(), ItemPostActivity.class);
                //startActivity(intent);
            }
        });

    }

    class SingerAdapter extends BaseAdapter{
        ArrayList<SingerItem> items = new ArrayList<SingerItem>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(SingerItem item) {
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
            SingerItemView view = null;
            if (convertView == null) {
                view = new SingerItemView(getApplicationContext());
            } else {
                view = (SingerItemView) convertView;
            }

            SingerItem item = items.get(position);

            view.setName(item.getName());
            view.setMobile(item.getMobile());
            view.setImage(item.getResId());


            return view;
        }
    }


}


