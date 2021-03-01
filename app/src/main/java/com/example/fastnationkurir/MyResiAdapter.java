package com.example.fastnationkurir;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyResiAdapter extends RecyclerView.Adapter<MyResiAdapter.MyResiViewHolder> {
    ArrayList<Resi> DataSessionResiUser;
    public MyResiAdapter(ArrayList<Resi> DataSessionResiUser) {this.DataSessionResiUser = DataSessionResiUser;}
    @NonNull
    @Override
    public MyResiAdapter.MyResiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_myresi, parent, false);
        return new MyResiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyResiViewHolder holder, int position) {
        holder.tvNoresi.setText(DataSessionResiUser.get(position).getNoresi());
        holder.tvNamapengirim.setText(DataSessionResiUser.get(position).getNamapengirim());
        holder.tvNamapenerima.setText(DataSessionResiUser.get(position).getNamapenerima());
        holder.tvKotaasal.setText(DataSessionResiUser.get(position).getKotaasal());
        holder.tvKotatujuan.setText(DataSessionResiUser.get(position).getKotatujuan());
        holder.tvStatus.setText(DataSessionResiUser.get(position).getStatus());
    }

    @Override
    public int getItemCount() {
        return (DataSessionResiUser != null) ? DataSessionResiUser.size() : 0;
    }

    public class MyResiViewHolder extends RecyclerView.ViewHolder {

        private TextView tvNoresi,tvNamapengirim, tvNamapenerima, tvKotaasal, tvKotatujuan, tvStatus;

        public MyResiViewHolder(View view) {
            super(view);

            tvNoresi = view.findViewById(R.id.tv_resinoresi);
            tvNamapengirim = view.findViewById(R.id.tv_resinamapengirim);
            tvNamapenerima = view.findViewById(R.id.tv_resinamapenerima);
            tvKotaasal = view.findViewById(R.id.tv_resikotaasal);
            tvKotatujuan = view.findViewById(R.id.tv_resikotatujuan);
            tvStatus = view.findViewById(R.id.tv_resistatus);
        }
    }
}

