package com.hyphencoder.zaikazon.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.hyphencoder.zaikazon.Model.RestroModel2;
import com.hyphencoder.zaikazon.R;
import com.hyphencoder.zaikazon.Activity.RestroScreen;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RestroModelAdapter2 extends RecyclerView.Adapter<RestroModelAdapter2.ViewHolder> {

    Context context;
    List<RestroModel2> restroModel2List;

    public RestroModelAdapter2(Context context , List<RestroModel2> restroModel2List) {
        this.restroModel2List = restroModel2List;
        this.context=context;
    }

    @NonNull
    @Override
    public RestroModelAdapter2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_restroitem_horizental,parent, false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestroModelAdapter2.ViewHolder holder, int position) {
        RestroModel2 restroModel2 = restroModel2List.get(position);

        holder.restaurant_name.setText(restroModel2.getName());
        holder.restro_location.setText(restroModel2.getLocation());
        holder.res_desc.setText(restroModel2.getDesc());
        Picasso.get().load(restroModel2.getImageUrl()).into(holder.img1);
        holder.img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, RestroScreen.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return restroModel2List.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img1;
        TextView restaurant_name, res_desc;
        TextView restro_location;
        CardView cardView1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img1=itemView.findViewById(R.id.img1);
            restaurant_name=itemView.findViewById(R.id.restaurant_name);
            restro_location=itemView.findViewById(R.id.restro_locationH);
            res_desc= itemView.findViewById(R.id.txt_discription);
            cardView1=itemView.findViewById(R.id.cardview1);
        }
    }
}
