package com.example.fastnationkurir;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RatesAdapter extends RecyclerView.Adapter<RatesAdapter.RatesViewHolder> {
    ArrayList<Rates> Arrrates;
    public RatesAdapter(ArrayList<Rates> Arrrates) {this.Arrrates = Arrrates;}
    @NonNull
    @Override
    public RatesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_rates, parent, false);
        return new RatesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RatesViewHolder holder, int position) {
        holder.tvAsal.setText(Arrrates.get(position).getKotaasal());
        holder.tvKe.setText(Arrrates.get(position).getKotatujuan());
        holder.tvHarga.setText(Arrrates.get(position).getHarga());
    }

    @Override
    public int getItemCount() {
        return (Arrrates != null) ? Arrrates.size() : 0;
    }

    public class RatesViewHolder extends RecyclerView.ViewHolder {

        private TextView tvAsal,tvKe,tvHarga;

        public RatesViewHolder(View view) {
            super(view);
            tvAsal = view.findViewById(R.id.tv_ratesdari);
            tvKe = view.findViewById(R.id.tv_rateske);
            tvHarga = view.findViewById(R.id.tv_ratesharga);
        }
    }
}


