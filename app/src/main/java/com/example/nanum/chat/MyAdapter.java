package com.example.nanum.chat;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.nanum.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    public ArrayList<DataItem> myDataList = null;

    MyAdapter(ArrayList<DataItem> dataList)
    {
        myDataList = dataList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view;
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

/*        if(viewType == Code.ViewType.CENTER_CONTENT)
        {
            view = inflater.inflate(R.layout.center_content, parent, false);
            return new CenterViewHolder(view);
        }*/
        if(viewType == Code.ViewType.LEFT_CONTENT)
        {
            view = inflater.inflate(R.layout.chatting_send_item, parent, false);
            return new LeftViewHolder(view);
        }
        else
        {
            view = inflater.inflate(R.layout.chatting_post_item, parent, false);
            return new RightViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position)
    {
        if(viewHolder instanceof CenterViewHolder)
        {
            ((CenterViewHolder) viewHolder).content.setText(myDataList.get(position).getContent());
        }
        else if(viewHolder instanceof LeftViewHolder)
        {
            ((LeftViewHolder) viewHolder).name.setText(myDataList.get(position).getName());
            ((LeftViewHolder) viewHolder).content.setText(myDataList.get(position).getContent());
        }
        else
        {
            ((RightViewHolder) viewHolder).name.setText(myDataList.get(position).getName());
            ((RightViewHolder) viewHolder).content.setText(myDataList.get(position).getContent());
        }
    }

    @Override
    public int getItemCount()
    {
        return myDataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return myDataList.get(position).getViewType();
    }

    public class CenterViewHolder extends RecyclerView.ViewHolder{
        TextView content;

        CenterViewHolder(View itemView)
        {
            super(itemView);

            content = itemView.findViewById(R.id.content);
        }
    }

    public class LeftViewHolder extends RecyclerView.ViewHolder{
        TextView content;
        TextView name;
        ImageView image;

        LeftViewHolder(View itemView)
        {
            super(itemView);

            content = itemView.findViewById(R.id.chatSendText);
            name = itemView.findViewById(R.id.chatSendName);
            image = itemView.findViewById(R.id.chatSendImg);
        }
    }

    public class RightViewHolder extends RecyclerView.ViewHolder{
        TextView content;
        TextView name;
        ImageView image;

        RightViewHolder(View itemView)
        {
            super(itemView);

            content = itemView.findViewById(R.id.chatPostText);
            name = itemView.findViewById(R.id.chatPostName);
            image = itemView.findViewById(R.id.chatPostImg);
        }
    }





    public class Code {
        public class ViewType{
            public static final int LEFT_CONTENT = 0;
            public static final int RIGHT_CONTENT = 1;
            public static final int CENTER_CONTENT = 2;
        }
    }
}
