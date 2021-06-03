package com.example.nanum.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.nanum.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class HomeTabFragment extends Fragment // Fragment 클래스를 상속받아야한다
{
    SingerAdapter adapter;
    ScrollView sv;
    ListView listView;
    FloatingActionButton postBtn;


    private View view;

    TextView text;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.home_layout,container,false);

        sv = (ScrollView) view.findViewById(R.id.homeSV);
        listView = (ListView)  view.findViewById(R.id.homeListView);
        postBtn = (FloatingActionButton) view.findViewById(R.id.homePost);


        adapter = new SingerAdapter();

        adapter.addItem(new SingerItem("소녀시대", "01071803396", R.drawable.pic, "#아이돌"));
        adapter.addItem(new SingerItem("유용현", "01071803396", R.drawable.pic, "#용용"));

        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SingerItem item = (SingerItem) adapter.getItem(position);
                Toast.makeText(getActivity().getApplicationContext(), "선택 :"+item.getName(), Toast.LENGTH_LONG).show();
            }
        });

        postBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( view.getContext(), PostTabActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }


    class SingerAdapter extends BaseAdapter {
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
                view = new SingerItemView(getActivity().getApplicationContext());
            } else {
                view = (SingerItemView) convertView;
            }

            SingerItem item = items.get(position);

            view.setName(item.getName());
            view.setMobile(item.getMobile());
            view.setImage(item.getResId());
            view.setKeyword(item.getKeyword());


            return view;
        }
    }

}