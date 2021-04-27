package com.example.onthigiuaky_ghe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class ghe_select extends AppCompatActivity {

    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ghe_select);
        ImageView imgGheSelect = findViewById(R.id.imgGheSelect);
        TextView txtTenSelect = findViewById(R.id.txtTenSelect);
        TextView txtGiaSelect = findViewById(R.id.txtGiaSelect);
        btnAdd = findViewById(R.id.btnAdd);

        String name = "";
        int img = 0;
        String gia="";
        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            name = extras.getString("username");
            img = extras.getInt("img");
            gia = extras.getString("gia");
        }

        txtTenSelect.setText(name);
        txtGiaSelect.setText(gia);
        imgGheSelect.setImageResource(img);


        String finalName = name;
        String finalGia = gia;
        int finalImg = img;
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ActivityC.class);
                intent.putExtra("username",txtTenSelect.getText());
                intent.putExtra("img", imgGheSelect.getImageAlpha());
                intent.putExtra("gia", txtGiaSelect.getText());
                startActivity(intent);
                Ghe g = new Ghe(Integer.parseInt(String.valueOf(finalImg)) , finalName.toString(), finalGia.toString());

                DanhSachGheChon.getInstance().AddGhe(g);
            }
        });
    }
}