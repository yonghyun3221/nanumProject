package com.example.nanum.chat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.nanum.R;

import java.util.ArrayList;

public class ChatTabFragment extends Fragment // Fragment 클래스를 상속받아야한다
{
    SingerAdapter_chat_send sendAdapter;
    ScrollView sv;
    ListView listView;

    private View view;
    TextView text;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.chat_layout,container,false);

        sv = (ScrollView)view.findViewById(R.id.chatSV);
        listView = (ListView)view.findViewById(R.id.chatlListView);
        sendAdapter = new SingerAdapter_chat_send();


        sendAdapter.addItem(new ChattingSendItem("유용현", "끝낫나?", R.drawable.flower));

        listView.setAdapter(sendAdapter);



        return view;
    }

    class SingerAdapter_chat_send extends BaseAdapter {
        ArrayList<ChattingSendItem> items = new ArrayList<ChattingSendItem>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(ChattingSendItem item) {
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
            ChattingSendView view = null;
            if (convertView == null) {
                view = new ChattingSendView(getActivity().getApplicationContext());
            } else {
                view = (ChattingSendView) convertView;
            }

            ChattingSendItem item = items.get(position);

            view.setName(item.getName());
            view.setMobile(item.getMobile());
            view.setImage(item.getResId());


            return view;
        }
    }

}