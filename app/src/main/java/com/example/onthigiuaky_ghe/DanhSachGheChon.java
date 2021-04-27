package com.example.onthigiuaky_ghe;

import java.util.ArrayList;

public class DanhSachGheChon {
    private static DanhSachGheChon instance;
    public ArrayList<Ghe> arrayListGheChon ;
    private DanhSachGheChon(){
        this.arrayListGheChon = new ArrayList<>();
    }
    public static DanhSachGheChon getInstance(){
        if(instance==null)
            instance = new DanhSachGheChon();
        return instance;
    }
    public ArrayList<Ghe> getDSGhe(){
        return this.arrayListGheChon;
    }
    public void AddGhe(Ghe gheChon){
        Ghe ghe = new Ghe();
        ghe.setImg(gheChon.getImg());
        ghe.setGia(gheChon.getGia());
        ghe.setTen(gheChon.getTen());
        arrayListGheChon.add(ghe);
    }

    public int getSize(){
        return arrayListGheChon.size();
    }
}
