package com.example.nanum.chat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nanum.R;
import com.example.nanum.login.LoginActivity;

import java.util.ArrayList;

public class ChatTabFragment extends Fragment // Fragment 클래스를 상속받아야한다
{

    SingerAdapter_chat_send sendAdapter;
    SingerAdapter_chat_post postAdapter;
    ScrollView sv;
    ListView listView;
    Button btnPost;
    RecyclerView recyclerView;
    private View view;
    TextView text;
    EditText edit;

    ArrayList<DataItem> dataList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.chat_activity_main,container,false);


/*
        sv = (ScrollView)view.findViewById(R.id.chatSV);
        listView = (ListView)view.findViewById(R.id.chatlListView);

        sendAdapter = new SingerAdapter_chat_send();
        postAdapter = new SingerAdapter_chat_post();

        sendAdapter.addItem(new ChattingSendItem("유용현", "끝낫나?", R.drawable.flower));
        postAdapter.addItem(new ChattingPostItem("김창주", "아니??", R.drawable.flower));

        sendAdapter.addItem(new ChattingSendItem("유용현1", "끝낫나1?", R.drawable.flower));
        postAdapter.addItem(new ChattingPostItem("김창주1", "아니??1", R.drawable.flower));



        listView.setAdapter(sendAdapter);
        listView.setAdapter(postAdapter);*/

        btnPost = (Button) view.findViewById(R.id.chatSendBtn);
        edit = (EditText)view.findViewById(R.id.chatEditText);

        btnPost.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dataList.add(new DataItem("sleep", "유용현", Code.ViewType.LEFT_CONTENT));
                System.out.println("dataList = : " + dataList.toString());


                recyclerView.setAdapter(new MyAdapter(dataList));

                edit.setText(null);
            }
        });

        edit.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey (View v,int KeyCode, KeyEvent event){
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && KeyCode == KeyEvent.KEYCODE_ENTER) {
                    btnPost.performClick();
                    return true;
                }
                edit.setText(null);
                return false;
            }
        });

        this.initializeData();



        recyclerView = view.findViewById(R.id.chat_recyclerview);
        LinearLayoutManager manager
                = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(manager); // LayoutManager 등록
        recyclerView.setAdapter(new MyAdapter(dataList));  // Adapter 등록


        return view;
    }


    public void initializeData()
    {
        dataList = new ArrayList<>();

        dataList.add(new DataItem("안안녕녕녕녕녕하세요", "유용현", Code.ViewType.LEFT_CONTENT));
        dataList.add(new DataItem("안이녀어엉어어어어어어하하하게게세세세세ㅔ요ㅛ요요요요요요용녕하세요", "김창주", Code.ViewType.RIGHT_CONTENT));

    }


    public class Code {
        public class ViewType{
            public static final int LEFT_CONTENT = 0;
            public static final int RIGHT_CONTENT = 1;
        }
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

    class SingerAdapter_chat_post extends BaseAdapter {
        ArrayList<ChattingPostItem> items = new ArrayList<ChattingPostItem>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(ChattingPostItem item) {
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
            ChattingPostView view = null;
            if (convertView == null) {
                view = new ChattingPostView(getActivity().getApplicationContext());
            } else {
                view = (ChattingPostView) convertView;
            }

            ChattingPostItem item = items.get(position);

            view.setName(item.getName());
            view.setMobile(item.getMobile());
            view.setImage(item.getResId());


            return view;
        }
    }

}