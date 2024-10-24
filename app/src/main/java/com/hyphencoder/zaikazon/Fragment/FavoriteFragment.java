package com.hyphencoder.zaikazon.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hyphencoder.zaikazon.Model.FavoriteModel;
import com.hyphencoder.zaikazon.Adapter.FavoriteModelAdapter;
import com.hyphencoder.zaikazon.Activity.MainActivity;
import com.hyphencoder.zaikazon.R;

import java.util.ArrayList;
import java.util.List;

public class FavoriteFragment extends Fragment {

    ImageView backbtnf;
    RecyclerView frecycler;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_favorite, container, false);

        // back btn..

        backbtnf=view.findViewById(R.id.backbtnf);
        backbtnf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FavoriteFragment fragmentB = new FavoriteFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container_view, fragmentB);
                transaction.addToBackStack(null); // Optional: Add to back stack
                transaction.commit();

                MainActivity.bottom_navigate.setSelectedItemId(R.id.home);
            }
        });

        //set recycler view
        frecycler=view.findViewById(R.id.frecycler);


        return view;
    }
}