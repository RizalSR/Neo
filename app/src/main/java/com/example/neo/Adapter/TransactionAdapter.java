package com.example.neo.Adapter;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.neo.Model.DataTrasaction;
import com.example.neo.R;

import org.w3c.dom.Text;

public class TransactionAdapter extends RecyclerView.Adapter {

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_transaction_recycle_item, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ListViewHolder) holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return DataTrasaction.name.length;
    }

    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView flag;
        private TextView name;
        private TextView dates;
        private TextView money;

        public ListViewHolder(View itemView){

            super(itemView);
            flag = (ImageView) itemView.findViewById(R.id.item_transaction_image);
            name = (TextView) itemView.findViewById(R.id.item_transaction_name);
            dates = (TextView) itemView.findViewById(R.id.item_transaction_date);
            money = (TextView) itemView.findViewById(R.id.item_transaction_money);
        }

        public void bindView(int position){
            flag.setImageResource(DataTrasaction.flag[position]);
            name.setText(DataTrasaction.name[position]);
            dates.setText(DataTrasaction.dates[position]);
            money.setText(DataTrasaction.money[position]);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
