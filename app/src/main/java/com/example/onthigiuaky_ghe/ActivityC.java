package com.example.onthigiuaky_ghe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ActivityC extends AppCompatActivity {
    RecyclerView recyclerGheChon;
    ArrayList<Ghe> arrayList;
    private CustomGheChonAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
        initView();

    }

    private void initView() {
            recyclerGheChon = (RecyclerView)findViewById(R.id.recylerGheChon);
            recyclerGheChon.setHasFixedSize(true);
            GridLayoutManager layoutManager= new GridLayoutManager(this,1);
            recyclerGheChon.setLayoutManager(layoutManager);
            arrayList = new ArrayList<>();
            arrayList = DanhSachGheChon.getInstance().getDSGhe();
            mAdapter = new CustomGheChonAdapter(arrayList);
            recyclerGheChon.setAdapter(mAdapter);

    }
}