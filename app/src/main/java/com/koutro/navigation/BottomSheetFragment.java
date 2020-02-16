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

public class BottomSheetFragment extends Fragment implements MenuItem.OnMenuItemClickListener {

    private View view;
    private BottomNavigationView bottomNavigationView;
    private Fragment nestedFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.bottom_sheet_fragment, container,false);
        bottomNavigationView = view.findViewById(R.id.toolbar);
        //view.findViewById(R.id.up).setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View v) {
        //        BottomSheetBehavior behavior = BottomSheetBehavior.from(view.findViewById(R.id.parentBottom));
        //        behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        //    }
        //});
        //toolbar.inflateMenu(R.menu.menu_nav);
        bottomNavigationView.getMenu().findItem(R.id.one).setOnMenuItemClickListener(this);
        bottomNavigationView.getMenu().findItem(R.id.two).setOnMenuItemClickListener(this);
        bottomNavigationView.getMenu().findItem(R.id.three).setOnMenuItemClickListener(this);

        return view;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
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
        return false;
    }
}
