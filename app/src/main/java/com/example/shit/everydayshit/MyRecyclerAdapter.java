package com.example.shit.everydayshit;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by He on 2016/5/16.
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.RecycViewHolder> {
    private String[] datas = new String[DownloadJSON.getROWS()];
    private String[] data2 = new String[DownloadJSON.getROWS()];
    private Context context;

    public MyRecyclerAdapter(Context context) {
        this.context = context;
        for (int i = 0; i < datas.length; i++) {
            //data2[i] = DownloadJSON.getDataFromNet();
            datas[i] = "a"+i;
        }
    }


    @Override
    public RecycViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecycViewHolder holder = new RecycViewHolder(LayoutInflater.from(context).inflate(R.layout.item_of_recyclerview, parent, false));


        return holder;
    }

    @Override
    public void onBindViewHolder(MyRecyclerAdapter.RecycViewHolder holder, int position) {
        holder.tv.setText(datas[position]);
    }

    @Override
    public int getItemCount() {
        return datas.length;
    }




    public static class RecycViewHolder extends RecyclerView.ViewHolder {
        TextView tv;

        public RecycViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.textview_of_recycler_item);
        }
    }




}
