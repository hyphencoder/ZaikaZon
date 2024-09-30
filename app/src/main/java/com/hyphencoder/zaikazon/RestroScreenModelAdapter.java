package com.hyphencoder.zaikazon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class RestroScreenModelAdapter extends RecyclerView.Adapter<RestroScreenModelAdapter.ViewHolder> {
    Context context;
    List<RestroScreenModel> restroScreenModelList;

    public RestroScreenModelAdapter(Context context, List<RestroScreenModel> restroScreenModelList) {
        this.context = context;
        this.restroScreenModelList = restroScreenModelList;
    }


    @NonNull
    @Override
    public RestroScreenModelAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.lay_show_review,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestroScreenModelAdapter.ViewHolder holder, int position) {
        RestroScreenModel restroScreenModel=restroScreenModelList.get(position);

        holder.username.setText(restroScreenModel.getName());
        holder.txtReview.setText(restroScreenModel.getTxtreview());
        holder.time.setText(restroScreenModel.getTime());
    }

    @Override
    public int getItemCount() {
        return restroScreenModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView userImg;
        TextView time;
        TextView txtReview;
        TextView username;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userImg=itemView.findViewById(R.id.userimg);
            time=itemView.findViewById(R.id.time);
            txtReview=itemView.findViewById(R.id.txt_review);
            username=itemView.findViewById(R.id.username);
        }
    }
}
