package com.example.nanum.chat;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.nanum.R;
import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {
    private ArrayList<DataItem> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_activity_main);

        this.initializeData();

        RecyclerView recyclerView = findViewById(R.id.chat_recyclerview);
        LinearLayoutManager manager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(manager); // LayoutManager 등록

        dataList.add(new DataItem("안녕하세요", "사용자1", Code.ViewType.LEFT_CONTENT));
        dataList.add(new DataItem("안녕하세요", "사용자2", Code.ViewType.RIGHT_CONTENT));


        recyclerView.setAdapter(new MyAdapter(dataList));  // Adapter 등록
    }




    public class Code {
        public class ViewType{
            public static final int LEFT_CONTENT = 0;
            public static final int RIGHT_CONTENT = 1;
            public static final int CENTER_CONTENT = 2;
        }
    }


    public void initializeData()
    {
        dataList = new ArrayList<>();

        dataList.add(new DataItem("안녕하세요", "사용자1", Code.ViewType.LEFT_CONTENT));
        dataList.add(new DataItem("안녕하세요", "사용자2", Code.ViewType.RIGHT_CONTENT));

    }
}
