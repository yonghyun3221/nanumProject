package com.example.nanum;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class SocialTabFragment extends Fragment{ // Fragment 클래스를 상속받아야한다
    private View view;
    SingerAdapter_social adapter;
    ScrollView sv;
    ListView listView;
    FloatingActionButton postBtn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.social_layout,container,false);


        sv = (ScrollView)view.findViewById(R.id.chatSV);
        listView = (ListView)view.findViewById(R.id.chatlListView);
        postBtn = (FloatingActionButton)view.findViewById(R.id.socialPost);
        adapter = new SingerAdapter_social();


        adapter.addItem(new SingerItem_Social("소녀시대", "01071803396", R.drawable.pic));
        adapter.addItem(new SingerItem_Social("소2녀시대", "01071803396", R.drawable.pic));
        adapter.addItem(new SingerItem_Social("소3녀시대", "01071803396", R.drawable.pic));
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SingerItem_Social item = (SingerItem_Social) adapter.getItem(position);
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
                view = new SingerItemView_Social(getActivity().getApplicationContext());
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