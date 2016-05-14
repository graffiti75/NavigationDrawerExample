package com.example.android.navigationdrawerexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.List;

public class SimpleListFragment extends Fragment {

    //--------------------------------------------------
    // Fragment Life Cycle
    //--------------------------------------------------

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_simple_list, container, false);
        setupRecyclerView(recyclerView);
        return recyclerView;
    }

    //--------------------------------------------------
    // Methods
    //--------------------------------------------------

    private void setupRecyclerView(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        List<String> list = Arrays.asList("Texto", "Texto 2", "Texto 3" );
        recyclerView.setAdapter(new SimpleListAdapter(list));
    }
}