package com.koutro.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.navigation.NavigationView;

public class BottomSheetFragment extends Fragment implements OnAttached{

    private View view;
    private BottomNavigationView bottomNavigationView;
    private Fragment nestedFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.bottom_sheet_fragment, container,false);
        bottomNavigationView = view.findViewById(R.id.toolbar);
        return view;
    }


    private void addNavToBottomNav(){
        if(getParentFragment() instanceof GlobalFragment)
            nestedFragment = ((GlobalFragment)getParentFragment()).getAdapter().getItem(0);
        NavHostFragment navHostFragment = null;
        for(Fragment fragment : nestedFragment.getChildFragmentManager().getFragments()){
            if(fragment instanceof NavHostFragment) {
                navHostFragment = (NavHostFragment) fragment;
            }
        }
        if(navHostFragment != null)
            NavigationUI.setupWithNavController(bottomNavigationView, navHostFragment.getNavController());
    }

    @Override
    public void onAttached() {
        addNavToBottomNav();
    }
}
