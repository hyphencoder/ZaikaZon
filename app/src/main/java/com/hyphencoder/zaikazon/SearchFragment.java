package com.hyphencoder.zaikazon;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;


public class SearchFragment extends Fragment {

    ImageView backbtns;

    RecyclerView s_recycler;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_search, container, false);


        // back btn code.....

        backbtns=view.findViewById(R.id.backbtns);
        backbtns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchFragment fragmentB = new SearchFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container_view, fragmentB);
                transaction.addToBackStack(null); // Optional: Add to back stack
                transaction.commit();

                MainActivity.bottom_navigate.setSelectedItemId(R.id.home);
            }
        });


        // Recycler view ....

        s_recycler=view.findViewById(R.id.s_recycler);

        List<RestroModel2> restroModel2List=new ArrayList<>();
        restroModel2List.add(new RestroModel2("", "Zaika Zon","Lucknow"));
        restroModel2List.add(new RestroModel2("", "Zaika Zon","Lucknow"));
        restroModel2List.add(new RestroModel2("", "Zaika Zon","Lucknow"));
        restroModel2List.add(new RestroModel2("", "Zaika Zon","Lucknow"));
        restroModel2List.add(new RestroModel2("", "Zaika Zon","Lucknow"));
        restroModel2List.add(new RestroModel2("", "Zaika Zon","Lucknow"));
        restroModel2List.add(new RestroModel2("", "Zaika Zon","Lucknow"));
        restroModel2List.add(new RestroModel2("", "Zaika Zon","Lucknow"));
        restroModel2List.add(new RestroModel2("", "Zaika Zon","Lucknow"));
        restroModel2List.add(new RestroModel2("", "Zaika Zon","Lucknow"));

        s_recycler.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        RestroModelAdapter2 restroModelAdapter2=new RestroModelAdapter2(getContext(),restroModel2List);
        s_recycler.setAdapter(restroModelAdapter2);

        return  view;
    }
}