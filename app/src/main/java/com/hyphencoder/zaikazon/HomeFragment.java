package com.hyphencoder.zaikazon;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    CardView search;
    RecyclerView restrorecycler;
    RecyclerView restrorecycler2;
    RecyclerView toprecycler;
    TextView txtseeall, txtseeall2, txt_nearby, txt_recommend;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Search .....
        search=view.findViewById(R.id.search);
        txtseeall2=view.findViewById(R.id.txt_see_all2);
        txt_nearby=view.findViewById(R.id.txt_nearby);
        toprecycler=view.findViewById(R.id.toprecycler);
        txtseeall=view.findViewById(R.id.txt_see_all);
        txt_recommend=view.findViewById(R.id.txt_recommend);
        restrorecycler=view.findViewById(R.id.restrorecycler);
        restrorecycler2=view.findViewById(R.id.restrorecycler2);



        // serachbar ke click pr ....
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SearchFragment fragmentB = new SearchFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container_view, fragmentB);
                transaction.addToBackStack(null);
                transaction.commit();

                MainActivity.bottom_navigate.setSelectedItemId(R.id.search);
            }
        });

        // Top recycler....
          showData();

        // See all  code...
        txtseeall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), Recommended.class);
                txt_recommend.getText().toString();
                intent.putExtra("data","Recommened Restaurants");
                startActivity(intent);
            }
        });

        // First Recycler view ....
         restroShow();

        // Second see all  activity .......
        txtseeall2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), Recommended.class);
                txt_nearby.getText().toString();
                intent.putExtra("data","Nearby Restaurants");
                startActivity(intent);
            }
        });

        //Second recycler view .....
        nearbyRestroShow();


        return view;
    }


// Top recycler ka data show krane ke liye...

    void showData(){
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference databaseReference=firebaseDatabase.getReference("CategoryName");

        List<TopRecyclerModel> topRecyclerModelList=new ArrayList<>();


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    Log.d("Database Refrences", "Snapshot Exists");

                   topRecyclerModelList.clear();

                    for(DataSnapshot snapshot1:snapshot.getChildren()){
                        TopRecyclerModel categoryModel=snapshot1.getValue(TopRecyclerModel.class);
                        topRecyclerModelList.add(categoryModel);
                    }

                    TopRecyclerModelAdapter adapter=new TopRecyclerModelAdapter(getContext(),topRecyclerModelList);
                    toprecycler.setAdapter(adapter);

                    toprecycler.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
                }else {
                    Log.d("Database Refrences", "Snapshot not exixts");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getContext(), "Data NOt Show", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Restraurants ke data show krane ke liye.....
    void restroShow(){
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference databaseReference=firebaseDatabase.getReference("Restaurant Name");

        List<RestroModel> restroModelList=new ArrayList<>();


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    Log.d("Database Refrences", "Snapshot Exists");

                    restroModelList.clear();

                    for(DataSnapshot snapshot1:snapshot.getChildren()){
                        RestroModel restroModel=snapshot1.getValue(RestroModel.class);
                        restroModelList.add(restroModel);
                    }

                    RestroModelAdapter adapter=new RestroModelAdapter(getContext(),restroModelList);
                    restrorecycler.setAdapter(adapter);

                    restrorecycler.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
                }else {
                    Log.d("Database Refrences", "Snapshot not exixts");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getContext(), "Data NOt Show", Toast.LENGTH_SHORT).show();
            }
        });
    }


    void nearbyRestroShow(){
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference databaseReference=firebaseDatabase.getReference("Restaurant Name");

        List<RestroModel2> restroModel2List=new ArrayList<>();


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    Log.d("Database Refrences", "Snapshot Exists");

                    restroModel2List.clear();

                    for(DataSnapshot snapshot1:snapshot.getChildren()){
                        RestroModel2 restroModel2=snapshot1.getValue(RestroModel2.class);
                        restroModel2List.add(restroModel2);
                    }

                    RestroModelAdapter2 adapter=new RestroModelAdapter2(getContext(),restroModel2List);
                    restrorecycler2.setAdapter(adapter);

                    restrorecycler2.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
                }else {
                    Log.d("Database Refrences", "Snapshot not exixts");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getContext(), "Data NOt Show", Toast.LENGTH_SHORT).show();
            }
        });
    }
}