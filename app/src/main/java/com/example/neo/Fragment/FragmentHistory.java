package com.example.neo.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.neo.Adapter.TransactionAdapter;
import com.example.neo.R;

public class FragmentHistory extends Fragment {
    private RecyclerView recyclerViewTransaction;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        recyclerViewTransaction = view.findViewById(R.id.history_recycle_trasaction);
        load_data_transaction();
        return view;
    }
    // Load Recycleview Data
    private void load_data_transaction(){
        TransactionAdapter listAdapter = new TransactionAdapter();
        recyclerViewTransaction.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerViewTransaction.setLayoutManager(layoutManager);
    }
}
