package com.example.onthigiuaky_ghe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerDonut;
    ArrayList<Ghe> arrayList;
    private CustomGheAdapter mAdapter;
    private CustomGheAdapter.ItemClickListner itemClickListner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void setOnClickListener() {
        itemClickListner = new CustomGheAdapter.ItemClickListner() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(),ghe_select.class);
                intent.putExtra("username",arrayList.get(position).getTen());
                intent.putExtra("img", arrayList.get(position).getImg());
                intent.putExtra("gia", arrayList.get(position).getGia());
                startActivity(intent);
            }
        };
    }
    private void initView() {
        recyclerDonut = (RecyclerView)findViewById(R.id.recylerGhe);
        recyclerDonut.setHasFixedSize(true);
        GridLayoutManager layoutManager= new GridLayoutManager(this,2);
        recyclerDonut.setLayoutManager(layoutManager);
        arrayList = new ArrayList<>();
        arrayList.add(new Ghe(R.drawable.ghe1,"Tasty Donut","$ 550"));
        arrayList.add(new Ghe(R.drawable.ghe2,"Morden Armchair","$ 350"));
        arrayList.add(new Ghe(R.drawable.ghe3,"Nice Armchair","$ 450"));
        arrayList.add(new Ghe(R.drawable.ghe4,"Circle Armchair","$ 400"));
        arrayList.add(new Ghe(R.drawable.ghe5,"Nice Armchair","$ 450"));
        arrayList.add(new Ghe(R.drawable.ghe6,"Matteo Armchair","$ 550"));

        setOnClickListener();
        mAdapter = new CustomGheAdapter(arrayList,itemClickListner);
        recyclerDonut.setAdapter(mAdapter);
    }

}