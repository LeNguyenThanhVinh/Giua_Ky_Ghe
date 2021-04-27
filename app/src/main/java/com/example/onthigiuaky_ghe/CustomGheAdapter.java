package com.example.onthigiuaky_ghe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomGheAdapter extends RecyclerView.Adapter<CustomGheAdapter.ViewHolder> {

    private ArrayList<Ghe> arrayList;
    private ItemClickListner listener;
    public interface ItemClickListner {
        void onClick(View v, int position);
    }
    public void setOnItemClick(ItemClickListner listner){
        listener = listner;
    }


    public CustomGheAdapter(ArrayList<Ghe> arrayList, ItemClickListner listener) {
        this.arrayList = arrayList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CustomGheAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =LayoutInflater.from(parent.getContext());
        View itemview =layoutInflater.inflate(R.layout.ghe,parent,false);
        return new ViewHolder(itemview, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomGheAdapter.ViewHolder holder, int position) {
        holder.imgGhe.setImageResource(arrayList.get(position).getImg());
        holder.txtGia.setText((arrayList.get(position).getGia()));
        holder.txtName.setText(arrayList.get(position).getTen());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imgGhe;
        TextView txtGia;
        TextView txtName;
        public ViewHolder(@NonNull View itemView, ItemClickListner listener) {
            super(itemView);
            txtName =itemView.findViewById(R.id.txtName);
            txtGia = itemView.findViewById(R.id.txtGia);
            imgGhe = itemView.findViewById(R.id.imgGhe);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(listener!=null){
                int position = getAdapterPosition();
                if(position!=RecyclerView.NO_POSITION){
                    listener.onClick(v, getAdapterPosition());
                }
            }
        }
    }
}
