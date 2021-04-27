package com.example.onthigiuaky_ghe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomGheChonAdapter extends RecyclerView.Adapter<CustomGheChonAdapter.ViewHolder> {
    private ArrayList<Ghe> arrayList;

    public CustomGheChonAdapter(ArrayList<Ghe> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public CustomGheChonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =LayoutInflater.from(parent.getContext());
        View itemview =layoutInflater.inflate(R.layout.ghechon,parent,false);
        return new ViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomGheChonAdapter.ViewHolder holder, int position) {
        holder.imgGhe.setImageResource(arrayList.get(position).getImg());
        holder.txtGia.setText((arrayList.get(position).getGia()));
        holder.txtName.setText(arrayList.get(position).getTen());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgGhe;
        TextView txtGia;
        TextView txtName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName =itemView.findViewById(R.id.txtGheChonC);
            txtGia = itemView.findViewById(R.id.txtGiaChonC);
            imgGhe = itemView.findViewById(R.id.imgGheChonC);
        }

    }
}
