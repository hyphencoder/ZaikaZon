package com.hyphencoder.zaikazon;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.window.SplashScreen;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RestroModelAdapter extends RecyclerView.Adapter<RestroModelAdapter.ViewHolder> {

    Context context;
    List<RestroModel> restroModelList;

    public RestroModelAdapter(Context context,List<RestroModel> restroModelList) {
        this.restroModelList = restroModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_restro_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        RestroModel restroModel = restroModelList.get(position);

        holder.restaurant_name.setText(restroModel.getName());
        holder.restro_location.setText(restroModel.getLocation());
        holder.restro_Desc.setText(restroModel.getDesc());
        holder.cardview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(context, RestroScreen.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return restroModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img1;
        TextView restaurant_name, restro_location,restro_Desc;
        CardView cardview1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img1 = itemView.findViewById(R.id.img1);
            restaurant_name = itemView.findViewById(R.id.restaurant_name);
            restro_location = itemView.findViewById(R.id.restro_loaction);
            restro_Desc = itemView.findViewById(R.id.restro_Description);
            cardview1 = itemView.findViewById(R.id.cardview12);
        }
    }
}
