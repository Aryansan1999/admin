package com.example.admin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class myAdapter extends RecyclerView.Adapter<myAdapter.viewHolder> {
    //OnClickHanler handler;
    Context context;
    ArrayList<users> usersArrayList;

    public myAdapter(Context context, ArrayList<users> usersArrayList) {
        // this.handler = handler;
        this.context = context;
        this.usersArrayList = usersArrayList;
    }

    @NonNull
    @Override
    public myAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.single_stock, parent, false);
        return new viewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull myAdapter.viewHolder holder, int position) {
        users user = usersArrayList.get(position);
        holder.fruitName.setText(user.fruitName);
        holder.fruitUnit.setText(user.fruitUnit);
        holder.fruitPrice.setText(user.fruitPrice);
    }

    @Override
    public int getItemCount() {
        return usersArrayList.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {

        TextView fruitName;
        TextView fruitPrice;
        TextView fruitUnit;

        public viewHolder obj2;
        public int a = 0;
        Button plus, minus;


        public viewHolder(@NonNull View itemView) {
            super(itemView);
            fruitName = itemView.findViewById(R.id.fruitName);
            fruitPrice = itemView.findViewById(R.id.fruitPrice);
            fruitUnit = itemView.findViewById(R.id.fruitUnit);
        }

    }
}

