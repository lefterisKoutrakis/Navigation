package com.koutro.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class GlobalFragment extends Fragment {

    private View view;
    private ViewPager viewPager;
    private PagerAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.global_fragment,container,false);

        viewPager = view.findViewById(R.id.pager);

        initializeViewPager();

        BottomSheetFragment bottomSheetFragment = (BottomSheetFragment) getChildFragmentManager().findFragmentByTag("bottom");
        if(bottomSheetFragment == null)
            bottomSheetFragment = new BottomSheetFragment();

        getChildFragmentManager().beginTransaction()
                .replace(R.id.bottom, bottomSheetFragment,"bottom")
                .commit();

        return view;
    }

    public ScreenSlidePagerAdapter getAdapter() { return (ScreenSlidePagerAdapter) mAdapter; }

    private void initializeViewPager() {
        mAdapter = new ScreenSlidePagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(mAdapter);
    }
}