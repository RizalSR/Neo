package com.example.neo.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.example.neo.Adapter.ContactAdapter;
import com.example.neo.Model.ModelAddContact;
import com.example.neo.Model.ModelContact;
import com.example.neo.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class FragmentLike extends Fragment {
    private RecyclerView rcontact;
    FloatingActionButton btn_add;
    private ContactAdapter cadapter;
    private ArrayList contactdata = new ArrayList();

    public static final int DIALOG_ADD_CONTACT_CODE = 303;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_like, container, false);
        //Inisialisasi
        rcontact = (RecyclerView) view.findViewById(R.id.recyclerView_contact);
        btn_add = (FloatingActionButton) view.findViewById(R.id.btn_add_kontak);

        start();
        data_init();
        //ArrayList<ModelContact> data = new ArrayList<ModelContact>(DataContact());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        this.rcontact.setLayoutManager(mLayoutManager);
        cadapter = new ContactAdapter(contactdata);
        rcontact.setAdapter(cadapter);
        return view;
    }
    private void start(){
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addContact();
            }
        });
    }

    private void showDialogFullScreen() {
        FragmentManager fm = getChildFragmentManager();
        DialogFragmenContact newFragment = new DialogFragmenContact();
        newFragment.setRequestCode(DIALOG_ADD_CONTACT_CODE);
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.add(android.R.id.content, newFragment).addToBackStack(null).commit();
        newFragment.setOnCallbackResult(new DialogFragmenContact.CallbackResult() {
            @Override
            public void sendResult(int requestCode, Object obj) {
                Toast.makeText(getContext(), ""+requestCode, Toast.LENGTH_SHORT).show();
                if (requestCode == DIALOG_ADD_CONTACT_CODE) {
                    //displayDataResult((ModelAddContact) obj);
                }
            }
        });

    }

    //private ArrayList<ModelContact> data = new ArrayList<ModelContact>(contactdata);

    private void data_init(){
        contactdata.add(new ModelContact("Nur Hendra Pratama",R.drawable.man,"000865520001","IDR"));
        contactdata.add(new ModelContact("Muhammad Setiadi Pratama",R.drawable.man,"0029878718798","USD"));
        contactdata.add(new ModelContact("Nia Anisa Fadhila",R.drawable.woman,"221008989712","IDR"));
    }

    private void addContact(){
        contactdata.add(new ModelContact("Rizal Said Ramadhan",R.drawable.man,"0000987126371","HKD"));
        cadapter.notifyDataSetChanged();
    }

}
