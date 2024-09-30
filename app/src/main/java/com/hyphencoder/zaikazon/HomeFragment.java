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
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SearchFragment fragmentB = new SearchFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container_view, fragmentB);
                transaction.addToBackStack(null); // Optional: Add to back stack
                transaction.commit();

                MainActivity.bottom_navigate.setSelectedItemId(R.id.search);
            }
        });

        // Top recycler....
        toprecycler=view.findViewById(R.id.toprecycler);
          showData();

        // See all  code. here................................

        txtseeall=view.findViewById(R.id.txt_see_all);
        txt_recommend=view.findViewById(R.id.txt_recommend);
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

        restrorecycler=view.findViewById(R.id.restrorecycler);

        List<RestroModel> restroModelList=new ArrayList<>();
        restroModelList.add(new RestroModel("","Zaika Zon","Lucknow"));
        restroModelList.add(new RestroModel("","Zaika Zon","Lucknow"));
        restroModelList.add(new RestroModel("","Zaika Zon","Lucknow"));
        restroModelList.add(new RestroModel("","Zaika Zon","Lucknow"));
        restroModelList.add(new RestroModel("","Zaika Zon","Lucknow"));
        restroModelList.add(new RestroModel("","Zaika Zon","Lucknow"));

        restrorecycler.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false));

        RestroModelAdapter restroModelAdapter=new RestroModelAdapter(getContext(),restroModelList);
        restrorecycler.setAdapter(restroModelAdapter);

        // Second see all  activity........

        txtseeall2=view.findViewById(R.id.txt_see_all2);
        txt_nearby=view.findViewById(R.id.txt_nearby);
        txtseeall2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), Recommended.class);
                txt_nearby.getText().toString();
                intent.putExtra("data","Nearby Restaurants");
                startActivity(intent);
            }
        });

        //Second recycler view

        restrorecycler2=view.findViewById(R.id.restrorecycler2);

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

        restrorecycler2.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        RestroModelAdapter2 restroModelAdapter2=new RestroModelAdapter2(getContext(),restroModel2List);
        restrorecycler2.setAdapter(restroModelAdapter2);

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
}