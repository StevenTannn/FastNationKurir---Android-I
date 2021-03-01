package com.example.fastnationkurir;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OutletAdapter extends RecyclerView.Adapter<OutletAdapter.OutletViewHolder> {
    public ArrayList<Outlet> listOutlet;

    public OutletAdapter(ArrayList<Outlet> listOutlet) {
        this.listOutlet = listOutlet;
    }

    @NonNull
    @Override
    public OutletAdapter.OutletViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_outlet, parent, false);
        return new OutletViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OutletAdapter.OutletViewHolder holder, int position) {
        holder.tvNama.setText(listOutlet.get(position).getNama());
        holder.tvAlamat.setText(listOutlet.get(position).getAlamat());
        holder.tvNotelp.setText(listOutlet.get(position).getNotelp());
    }

    @Override
    public int getItemCount() {
        return (listOutlet != null) ? listOutlet.size() : 0;
    }

    public class OutletViewHolder extends RecyclerView.ViewHolder {

        private TextView tvNama, tvAlamat, tvNotelp;

        public OutletViewHolder(View view) {
            super(view);

            tvNama = view.findViewById(R.id.tv_outletnama);
            tvAlamat = view.findViewById(R.id.tv_outletalamat);
            tvNotelp = view.findViewById(R.id.tv_outletphone);
        }
    }
}
