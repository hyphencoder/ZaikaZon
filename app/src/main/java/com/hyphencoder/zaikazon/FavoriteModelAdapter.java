package com.hyphencoder.zaikazon;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FavoriteModelAdapter extends RecyclerView.Adapter<FavoriteModelAdapter.ViewHolder> {

    Context context;
   List<FavoriteModel> favoriteModelList;

    public FavoriteModelAdapter(Context context, List<FavoriteModel> favoriteModelList) {
        this.context = context;
        this.favoriteModelList = favoriteModelList;
    }

    @NonNull
    @Override
    public FavoriteModelAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_fav_recycler, parent, false);
        return new FavoriteModelAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteModelAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return favoriteModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img, favoritebtn;
        TextView restroname, restrolocation, restrodis;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
            favoritebtn=itemView.findViewById(R.id.favoritebtn);
            restroname=itemView.findViewById(R.id.restroname);
            restrodis=itemView.findViewById(R.id.restro_Description);
            restrolocation=itemView.findViewById(R.id.restro_locationf);
        }
    }
}
