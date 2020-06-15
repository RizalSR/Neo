package com.example.neo.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.neo.Model.ModelKurs;
import com.example.neo.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class KursAdapter extends RecyclerView.Adapter {
    private List datakurs;

    public KursAdapter(List datakurs){
        this.datakurs = datakurs;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.table_kurs_list_item, parent, false);
        return new RowViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        RowViewHolder rowViewHolder = (RowViewHolder) holder;

        int rowpos = rowViewHolder.getAdapterPosition();
        if(rowpos == 0){
            rowViewHolder.txtnamakurs.setWidth(300);
            rowViewHolder.txtjual.setWidth(300);
            rowViewHolder.txtbeli.setWidth(300);
            rowViewHolder.txtnamakurs.setBackgroundResource(R.drawable.table_header_cell);
            rowViewHolder.txtbeli.setBackgroundResource(R.drawable.table_header_cell);
            rowViewHolder.txtjual.setBackgroundResource(R.drawable.table_header_cell);

            rowViewHolder.txtnamakurs.setText("Mata Uang");
            rowViewHolder.txtbeli.setText("Beli");
            rowViewHolder.txtjual.setText("Jual");
        }else {
            ModelKurs model = (ModelKurs) datakurs.get(rowpos -1);

            rowViewHolder.txtnamakurs.setBackgroundResource(R.drawable.table_content_cell);
            rowViewHolder.txtbeli.setBackgroundResource(R.drawable.table_content_cell);
            rowViewHolder.txtjual.setBackgroundResource(R.drawable.table_content_cell);

            rowViewHolder.txtnamakurs.setText(model.getMatauang());
            rowViewHolder.txtbeli.setText(Double.toString(model.getH_beli()));
            rowViewHolder.txtjual.setText(Double.toString(model.getH_jual()));
        }
    }

    @Override
    public int getItemCount() {
        return datakurs.size() + 1;
    }

    public class RowViewHolder extends RecyclerView.ViewHolder {
        TextView txtnamakurs;
        TextView txtbeli;
        TextView txtjual;

        RowViewHolder(View itemView) {
            super(itemView);
            txtnamakurs = (TextView) itemView.findViewById(R.id.txtkurs);
            txtbeli = (TextView) itemView.findViewById(R.id.txtbeli);
            txtjual = (TextView) itemView.findViewById(R.id.txtjual);
        }
    }
}
