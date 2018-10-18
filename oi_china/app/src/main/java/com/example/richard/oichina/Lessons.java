package com.example.richard.oichina;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Richard on 9/23/2018.
 */

public class Lessons extends AppCompatActivity{


    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lessons);

        tabLayout = findViewById(R.id.tabLayout_id);
        appBarLayout = findViewById(R.id.appbar_id);
        viewPager = findViewById(R.id.viewpager_id);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        viewPagerAdapter.addFragment(new FragmentBasic(), "基本");
        viewPagerAdapter.addFragment(new FragmentIntermediate(), "中间");
        viewPagerAdapter.addFragment(new FragmentAdvanced(), "先进");

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        //addingFragments();

    }

    private void addingFragments() {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        viewPagerAdapter.addFragment(new FragmentBasic(), "基本");
        viewPagerAdapter.addFragment(new FragmentIntermediate(), "中间");
        viewPagerAdapter.addFragment(new FragmentAdvanced(), "先进");

        adpaterSetup(viewPagerAdapter);
    }

    private void adpaterSetup(ViewPagerAdapter viewPagerAdapter) {
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
