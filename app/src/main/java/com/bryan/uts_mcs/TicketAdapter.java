package com.bryan.uts_mcs;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TicketAdapter extends RecyclerView.Adapter<TicketAdapter.TiketViewHolder> {
    private Context context;
    private ArrayList match, date;

    public TicketAdapter(Context context, ArrayList match, ArrayList date) {
        this.context = context;
        this.match = match;
        this.date = date;
    }





    @NonNull
    @Override
    public TiketViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_cart, parent, false);
        return new TiketViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TiketViewHolder holder, int position) {
        holder.tvMatch.setText(String.valueOf(match.get(position)));
        holder.tvDate.setText(String.valueOf(date.get(position)));


    }

    @Override
    public int getItemCount() {
        return match.size();
    }

    public class TiketViewHolder extends RecyclerView.ViewHolder {
        TextView tvMatch, tvDate;

        public TiketViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDate = itemView.findViewById(R.id.Date);
            tvMatch = itemView.findViewById(R.id.Match);
        }
    }
}
