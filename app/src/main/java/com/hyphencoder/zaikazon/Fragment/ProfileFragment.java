package com.hyphencoder.zaikazon.Fragment;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hyphencoder.zaikazon.Activity.EditProfile;
import com.hyphencoder.zaikazon.Activity.Login;
import com.hyphencoder.zaikazon.Activity.MainActivity;
import com.hyphencoder.zaikazon.Activity.Registration;
import com.hyphencoder.zaikazon.Helper.SharedPrefManager;
import com.hyphencoder.zaikazon.Model.UserDataModel;
import com.hyphencoder.zaikazon.R;

public class ProfileFragment extends Fragment {

    ImageView backbtnpro;
    Button edit_profile, logout;
    TextView name, mobile, email, address;
    DatabaseReference databaseReference;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // Initialize views
        backbtnpro = view.findViewById(R.id.backbtnpro);
        name = view.findViewById(R.id.name);
        mobile = view.findViewById(R.id.mobile);
        email = view.findViewById(R.id.email);
        address = view.findViewById(R.id.address);

        if(!SharedPrefManager.getInstance(getContext()).getUser().getName().equalsIgnoreCase("")){
            name.setText(SharedPrefManager.getInstance(getContext()).getUser().getName());
            email.setText(SharedPrefManager.getInstance(getContext()).getUser().getEmail());
            mobile.setText(SharedPrefManager.getInstance(getContext()).getUser().getNumber());
            address.setText(SharedPrefManager.getInstance(getContext()).getUser().getAddress());
        }

        // Back button code...
        backbtnpro.setOnClickListener(v -> {
            MainActivity.bottom_navigate.setSelectedItemId(R.id.home);
        });

        // Edit profile button
        edit_profile = view.findViewById(R.id.edit_profile);
        edit_profile.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), EditProfile.class);
            startActivity(intent);
        });

        // Logout button code
        logout = view.findViewById(R.id.logout);
        logout.setOnClickListener(v -> logout());
        return view;
    }


    void logout() {

        SharedPrefManager.getInstance(getContext()).logout();

        Intent intent = new Intent(getContext(), Login.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);

        if (getActivity() != null) {
            getActivity().finish();
        }
    }
}
