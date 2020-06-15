package com.example.neo.Fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.neo.Adapter.TransactionAdapter;
import com.example.neo.Helper.DBHelper;
import com.example.neo.Model.UserDetailsResponse;
import com.example.neo.R;

public class FragmentHome extends Fragment {

    //Deklarasi
    private String name;
    private TextView home_name;
    private CardView btn_foreign, btn_local;
    private RecyclerView recyclerViewTransaction;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //Inisialisasi
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerViewTransaction = view.findViewById(R.id.home_recycle_trasaction);
        home_name = (TextView) view.findViewById(R.id.home_profile_name);
        btn_foreign = (CardView) view.findViewById(R.id.button_foreign);
        btn_local = (CardView) view.findViewById(R.id.button_local);
        start();
        return view;
    }

    private void start(){

        //load_data_user();
        load_data_transaction();
        // button Foreign
        btn_foreign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // custom dialog
                final Dialog dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.dialog_home_foreign);

                dialog.show();
            }
        });
        // button Local
        btn_local.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // custom dialog
                final Dialog dialog = new Dialog(getContext());
                dialog.setContentView(R.layout.dialog_home_local);

                dialog.show();
            }
        });


    }
        // Load Recycleview Data
    private void load_data_transaction(){
        TransactionAdapter listAdapter = new TransactionAdapter();
        recyclerViewTransaction.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerViewTransaction.setLayoutManager(layoutManager);
    }

    private void load_data_user(){
        DBHelper db = new DBHelper(getActivity());
        name = db.getuser().getName();
        db.close();
        //Setting Text
        home_name.setText(name);
    }
}
