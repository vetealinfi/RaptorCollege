package com.codebake.raptor.raptorcollege.adapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.SparseArray;
import android.view.ViewGroup;

import com.codebake.raptor.raptorcollege.ui.ColegiosFragment;
import com.codebake.raptor.raptorcollege.ui.TabFragment1;
import com.codebake.raptor.raptorcollege.ui.TabFragment2;
import com.codebake.raptor.raptorcollege.ui.TabFragment3;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import Modelo.ColegioTransporte;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;
    TabLayout tabLayout;
    ViewPager viewPager;
    TabFragment1 tab1;
    ColegiosFragment tab2;
    TabFragment3 tab3;
    ColegioTransporte colegioTransporte;


    public PagerAdapter(FragmentManager fm, int NumOfTabs, ViewPager viewPager, ColegioTransporte colegioTransporte) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
        this.viewPager = viewPager;
        this.colegioTransporte=colegioTransporte;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                this.tab1 = TabFragment1.newInstance(viewPager,colegioTransporte);


                return this.tab1;
            case 1:
                //ColegiosFragment tab2 = new ColegiosFragment();


                this.tab2 = ColegiosFragment.newInstance(viewPager,colegioTransporte);
                return this.tab2;
            case 2:
                //TabFragment3 tab3 = new TabFragment3();

                this.tab3 = TabFragment3.newInstance(colegioTransporte);

                return this.tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }


}