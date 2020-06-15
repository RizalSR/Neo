package com.example.neo.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.neo.Model.ModelContact;
import com.example.neo.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter {

    private ArrayList<ModelContact> modelContacts;

    public ContactAdapter(ArrayList<ModelContact> modelContacts){
        this.modelContacts = modelContacts;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_item, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ListViewHolder) holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        if (modelContacts != null){
            return modelContacts.size();
        }else {
            return 0;
        }
    }

    public void notifyDataSetChanged(int updateIndex) {

    }

    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView name,bank,currency;
        private ImageView image;

        public ListViewHolder(View itemView){
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.contact_name);
            bank = (TextView) itemView.findViewById(R.id.contact_bank);
            currency = (TextView) itemView.findViewById(R.id.cotact_currency);
            image = (ImageView) itemView.findViewById(R.id.contact_image);
        }

        public void bindView(int position){
            ModelContact data = modelContacts.get(position);
            image.setImageResource(data.getC_image());
            name.setText(data.getC_name());
            bank.setText("Bank Account : "+data.getC_bank());
            currency.setText(data.getC_currency());
        }

        @Override
        public void onClick(View view) {

        }
    }
}
