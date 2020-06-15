package com.example.neo.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.neo.Activity.Login;
import com.example.neo.Activity.MainActivity;
import com.example.neo.Activity.Splashscreen;
import com.example.neo.Helper.DBHelper;
import com.example.neo.R;

public class FragmentProfile extends Fragment {

    // Deklarasi
    String name,email,strcountry,phone,id_number;
    int country;
    TextView txt_name,txt_email,txt_country,txt_phone,txt_id_number;
    CardView logout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        txt_name = (TextView) view.findViewById(R.id.txt_profile_name);
        txt_email = (TextView) view.findViewById(R.id.txt_profile_email);
        txt_country = (TextView) view.findViewById(R.id.txt_profile_country);
        txt_phone = (TextView) view.findViewById(R.id.txt_profile_phone);
        txt_id_number = (TextView) view.findViewById(R.id.txt_profile_id_number);
        logout = (CardView) view.findViewById(R.id.card_logout);
        start();
        return view;
    }

    private void start(){
        load_data();
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper db = new DBHelper(getActivity());
                db.deleteToken();
                db.deleteToken();
                db.close();
                startActivity(new Intent(getActivity(), Login.class));
                getActivity().finish();
            }
        });
    }

    private void load_data(){
        DBHelper db = new DBHelper(getActivity());
        name = db.getuser().getName();
        email = db.getuser().getEmail();
        phone = db.getuser().getPhone();
        id_number = db.getuser().getId_number();
        country = db.getuser().getCountry();
        db.close();

        //Check Country Name
        if (country == 1){
            strcountry = "Indonesia";
        }else{
            strcountry = "China";
        }

        if (id_number == null){
            id_number = "null";
        }

        txt_name.setText(name);
        txt_email.setText(email);
        txt_country.setText(strcountry);
        txt_phone.setText(phone);
        txt_id_number.setText(id_number);
    }
}
