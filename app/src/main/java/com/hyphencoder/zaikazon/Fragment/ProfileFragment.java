package com.hyphencoder.zaikazon.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.hyphencoder.zaikazon.Activity.EditProfile;
import com.hyphencoder.zaikazon.Activity.Login;
import com.hyphencoder.zaikazon.Activity.MainActivity;
import com.hyphencoder.zaikazon.R;

public class ProfileFragment extends Fragment {

    ImageView backbtnpro;
    Button edit_profile, logout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_profile, container, false);

        // Back btn code...

        backbtnpro=view.findViewById(R.id.backbtnpro);

        backbtnpro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProfileFragment fragmentB = new ProfileFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container_view, fragmentB);
                transaction.addToBackStack(null); // Optional: Add to back stack
                transaction.commit();

                MainActivity.bottom_navigate.setSelectedItemId(R.id.home);
            }
        });


        // edit button ....


        edit_profile=view.findViewById(R.id.edit_profile);
        edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), EditProfile.class);
                startActivity(intent);
            }
        });



        // logout button code....

        logout=view.findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getContext(), Login.class);
                startActivity(intent);
            }
        });

        return  view;
    }
}