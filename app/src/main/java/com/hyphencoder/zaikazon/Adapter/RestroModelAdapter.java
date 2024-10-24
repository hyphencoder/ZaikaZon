package com.hyphencoder.zaikazon.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hyphencoder.zaikazon.Model.FavoriteModel;
import com.hyphencoder.zaikazon.Model.RestroModel;
import com.hyphencoder.zaikazon.R;
import com.hyphencoder.zaikazon.Activity.RestroScreen;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RestroModelAdapter extends RecyclerView.Adapter<RestroModelAdapter.ViewHolder> {
    boolean status=true;
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
        Picasso.get().load(restroModel.getImageUrl()).into(holder.img1);
        holder.img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(context, RestroScreen.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("restroname",restroModel.getName());
                intent.putExtra("restrodesc",restroModel.getDesc());
                intent.putExtra("restrolocation",restroModel.getLocation());
                intent.putExtra("restroimg",restroModel.getImageUrl());
                context.startActivity(intent);
            }
        });

        holder.favoritebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (status){
                    holder.favoritebtn.setImageResource(R.drawable.baseline_favorite_24_d);

                    status=false;
                }else {
                    holder.favoritebtn.setImageResource(R.drawable.baseline_favorite_border_24);
                    status=true;
                }
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
        ImageView favoritebtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img1 = itemView.findViewById(R.id.img1);
            restaurant_name = itemView.findViewById(R.id.restaurant_name);
            restro_location = itemView.findViewById(R.id.restro_loaction);
            restro_Desc = itemView.findViewById(R.id.restro_Description);
            cardview1 = itemView.findViewById(R.id.cardview12);
            favoritebtn = itemView.findViewById(R.id.favoritebtn);
        }
    }
}
