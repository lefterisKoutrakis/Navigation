package com.koutro.navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class NestedNavFragment extends Fragment {

    private OnAttached listener;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(getParentFragment() != null)
            listener = (OnAttached) getParentFragment().getChildFragmentManager().findFragmentByTag("bottom");
        if(listener != null)
            listener.onAttached();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.nested_graph,container,false);
    }
}
