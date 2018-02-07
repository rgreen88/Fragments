package com.example.android.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private SectionsStatePagerAdapter mSectionsStatePagerAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Started");

        //calling support fragment manager directly by creating new adapter to the created class object
        mSectionsStatePagerAdapter = new SectionsStatePagerAdapter(getSupportFragmentManager());

        mViewPager = findViewById(R.id.container);

        //setup pager method called
        setupViewPager(mViewPager);
    }

    private void setupViewPager (ViewPager viewPager){
        SectionsStatePagerAdapter adapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Fragment1(), "Fragment 1"); //inflates first frag by default
        adapter.addFragment(new Fragment2(), "Fragment 2");
        adapter.addFragment(new Fragment3(), "Fragment 3");

        viewPager.setAdapter(adapter);
    }

    public void setViewPager (int fragmentNumber){

        mViewPager.setCurrentItem(fragmentNumber);

    }

    //method to save data before configuration change for frag
    public static class RetainedFragment1 extends Fragment {

        // data object we want to retain
        private Fragment1 data;

        // this method is only called once for this fragment
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            // retain this fragment
            setRetainInstance(true);
        }

        public void setData(Fragment1 data) {
            this.data = data;
        }

        public Fragment1 getData() {
            return data;
        }
    }
}
