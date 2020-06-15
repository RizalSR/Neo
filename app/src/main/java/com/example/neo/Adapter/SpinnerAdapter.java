package com.example.neo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.neo.Model.ModelKurs;
import com.example.neo.R;

import java.util.ArrayList;
import java.util.List;

public class SpinnerAdapter extends ArrayAdapter<ModelKurs> {

    public SpinnerAdapter(@NonNull Context context, ArrayList<ModelKurs> modelKurs) {
        super(context,0, modelKurs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return customView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return customView(position, convertView, parent);
    }

    public View customView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        if (convertView ==  null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.spinner_kurs_tem, parent, false);
        }

        ModelKurs modelKurs = getItem(position);
        TextView spinnertext = convertView.findViewById(R.id.kurs_nama);

        if (modelKurs != null)
        {
            spinnertext.setText(modelKurs.getMatauang());
        }
        return convertView;
    }
}
