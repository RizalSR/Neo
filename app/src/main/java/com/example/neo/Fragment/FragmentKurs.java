package com.example.neo.Fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.neo.Adapter.KursAdapter;
import com.example.neo.Adapter.SpinnerAdapter;
import com.example.neo.Model.ModelKurs;
import com.example.neo.R;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class FragmentKurs extends Fragment {
    //Deklarasi
    RecyclerView RecycleKurs;
    EditText input,output;
    Spinner foreign,local;
    String mu1,mu2;
    Double harga1, harga2;
    Double inputan;
    Double nilai;
    Button btn_kurs;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kurs, container, false);
        RecycleKurs = (RecyclerView) view.findViewById(R.id.recyclerViewDeliveryProductList);
        foreign = (Spinner) view.findViewById(R.id.spinner_kurs1);
        local = (Spinner) view.findViewById(R.id.spinner_kurs2);
        output = (EditText) view.findViewById(R.id.output_kurs);
        input = (EditText) view.findViewById(R.id.input_kurs);
        btn_kurs = (Button) view.findViewById(R.id.btn_kurs);

        //Inisialisasi start
        start();

        // Fungsi Spinner 1 & 2
        function_spinner1();
        function_spinner2();

        //Table
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        RecycleKurs.setLayoutManager(linearLayoutManager);

        KursAdapter adapter = new KursAdapter(DataKurs());
        RecycleKurs.setAdapter(adapter);
        return view;
    }

    // Data Kurs
    private List<ModelKurs> DataKurs(){
        List KursData = new ArrayList<>();
        KursData.add(new ModelKurs("USD", 14675, 14775));
        KursData.add(new ModelKurs("SGD", 10381, 10430));
        KursData.add(new ModelKurs("HKD", 1873, 1933));
        KursData.add(new ModelKurs("JPY", 135, 138));

        return KursData;
    }

    private void function_spinner1(){
        //Spinner
        //Convert List to ArrayList
        final ArrayList<ModelKurs> data = new ArrayList<ModelKurs>(DataKurs());
        SpinnerAdapter spinnerAdapter = new SpinnerAdapter(getActivity(), data);
        data.add(new ModelKurs("IDR",0,0));

        if (foreign != null)
        {
            foreign.setAdapter(spinnerAdapter);
        }
        foreign.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ModelKurs modelKurs = (ModelKurs) adapterView.getSelectedItem();
                mu1 = modelKurs.getMatauang();
                harga1 = modelKurs.getH_jual();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //End Spinner
    }

    private void function_spinner2(){
        //Spinner
        //Convert List to ArrayList
        final ArrayList<ModelKurs> data = new ArrayList<ModelKurs>(DataKurs());
        data.add(0,new ModelKurs("IDR",0,0));
        SpinnerAdapter spinnerAdapter = new SpinnerAdapter(getActivity(), data);


        if (local != null)
        {
            local.setAdapter(spinnerAdapter);
        }
        local.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ModelKurs modelKurs = (ModelKurs) adapterView.getSelectedItem();
                mu2 = modelKurs.getMatauang();
                harga2 = modelKurs.getH_jual();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //End Spinner
    }

    private void start(){
        btn_kurs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
            }
        });
    }

    private void calculate(){
        if (harga1 == 0)
        {
            //Get Harga Beli (IDR to Foreign)
            // Input Value Divided Harga Beli
            inputan = Double.parseDouble(input.getText().toString());
            nilai = inputan / harga2;
            String format2 = new DecimalFormat("#,###.00").format(nilai);
            output.setText(format2);

        }else if (harga2 == 0){
            inputan = Double.parseDouble(input.getText().toString());
            nilai = inputan * harga1;
            String format2 = new DecimalFormat("#,###.00").format(nilai);
            output.setText(format2);
        }else{
            // Get Harga Beli(Foreign and local)
            // Get MataUang
            // Change to IDR
            inputan = Double.parseDouble(input.getText().toString());
            Double nilai2;
            nilai = inputan * harga1;
            nilai2 = nilai / harga2;
            String format2 = new DecimalFormat("#,###.00").format(nilai2);
            output.setText(format2);
        }
    }
}
