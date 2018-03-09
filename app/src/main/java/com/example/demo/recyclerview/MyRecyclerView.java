package com.example.demo.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Created by 59246 on 2018/3/9.
 */

class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {
    private Context context;
    private List<JsonBean.ResultBean.DataBean> list;
    public MyRecyclerViewAdapter(MainActivity mainActivity, List<JsonBean.ResultBean.DataBean> data) {
        context=mainActivity;
        list=data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewAdapter.ViewHolder holder, int position) {

        Picasso.with(context).load(list.get(position).getThumbnail_pic_s()).into(holder.img);
        holder.title.setText(list.get(position).getTitle());
        holder.category.setText(list.get(position).getCategory());
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
         ImageView img;
         TextView title;
         TextView category;
        public ViewHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.contentImg);
            title=itemView.findViewById(R.id.title);
            category=itemView.findViewById(R.id.category);
        }
    }
}
