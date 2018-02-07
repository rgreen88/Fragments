package com.example.android.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Fragment2 extends Fragment {

    private static final String TAG = "Frag1";

    private Button btn_nav_fragment_1;
    private Button btn_nav_fragment_2;
    private Button btn_nav_fragment_3;
    private Button btn_second_activity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //remove super to inflate and return view object to fragment
        View view = inflater.inflate(R.layout.fragment2_layout,container,false);

        btn_nav_fragment_1 = view.findViewById(R.id.btn_nav_frag1);
        btn_nav_fragment_2 = view.findViewById(R.id.btn_nav_frag2);
        btn_nav_fragment_3 = view.findViewById(R.id.btn_nav_frag3);
        btn_second_activity = view.findViewById(R.id.btn_nav_second_activity);
        Log.d(TAG, "onCreateView: started");

        btn_nav_fragment_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getActivity() is context for the current fragment called
                Toast.makeText(getActivity(), "Going to Fragment 1", Toast.LENGTH_SHORT).show();
                ((MainActivity)getActivity()).setViewPager(0);
                //frag 1 = 0, 2 = 1, etc
            }
        });

        btn_nav_fragment_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Going to Fragment 2", Toast.LENGTH_SHORT).show();

                //referencing methods for fragment access
                ((MainActivity)getActivity()).setViewPager(1);
            }
        });

        btn_nav_fragment_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Going to Fragment 3", Toast.LENGTH_SHORT).show();
                ((MainActivity)getActivity()).setViewPager(2);            }
        });

        btn_second_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Going to Second Activity", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getActivity(), SecondActivity.class);
                startActivity(intent);
                //navigate to second activity using Intent
            }
        });

        return view;
    }
}
