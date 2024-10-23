package com.hyphencoder.zaikazon.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hyphencoder.zaikazon.Model.TopRecyclerModel;
import com.hyphencoder.zaikazon.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class TopRecyclerModelAdapter extends RecyclerView.Adapter<TopRecyclerModelAdapter.ViewHolder> {

    Context context;
    List<TopRecyclerModel> topRecyclerModelList;

    public TopRecyclerModelAdapter(Context context, List<TopRecyclerModel> topRecyclerModelList) {
        this.context = context;
        this.topRecyclerModelList = topRecyclerModelList;
    }

    @NonNull
    @Override
    public TopRecyclerModelAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lay_top_recycler,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopRecyclerModelAdapter.ViewHolder holder, int position) {

        TopRecyclerModel topRecyclerModel=topRecyclerModelList.get(position);
        holder.category_name.setText(topRecyclerModel.getName());
        Picasso.get().load(topRecyclerModel.getImageUrl()).into(holder.category_img);




    }

    @Override
    public int getItemCount() {
        return topRecyclerModelList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView category_img;
        TextView category_name;
        public ViewHolder(View view) {
            super(view);
            category_img=view.findViewById(R.id.category_img);
            category_name=view.findViewById(R.id.category_name);

        }
    }
}
