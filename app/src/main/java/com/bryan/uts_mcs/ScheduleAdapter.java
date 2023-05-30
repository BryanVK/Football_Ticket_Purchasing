package com.bryan.uts_mcs;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder> {

    ArrayList<Schedule> scheduleArrayList;

    public ScheduleAdapter(ArrayList<Schedule> scheduleArrayList) {
        this.scheduleArrayList = scheduleArrayList;
    }


    @NonNull
    @Override
    public ScheduleAdapter.ScheduleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_schedule, parent, false);
        return new ScheduleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleViewHolder holder, int position) {

        final Schedule schedule = scheduleArrayList.get(position);
        holder.tvMatch.setText(schedule.getMatch());
        holder.tvDate.setText(schedule.getDate());
        holder.image.setImageResource(schedule.getImage());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailScheduleActivity.class);
                intent.putExtra("SCHEDULE", schedule);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return scheduleArrayList.size();
    }

    public class ScheduleViewHolder extends RecyclerView.ViewHolder {
        TextView tvMatch, tvDate;
        ImageView image;
        public ScheduleViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDate = itemView.findViewById(R.id.Date);
            tvMatch = itemView.findViewById(R.id.Match);
            image = itemView.findViewById(R.id.image);
        }
    }
}
