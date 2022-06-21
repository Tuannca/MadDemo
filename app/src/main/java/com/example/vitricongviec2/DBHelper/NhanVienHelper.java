package com.example.vitricongviec2.DBHelper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.vitricongviec2.Model.NhanVien;

import java.util.ArrayList;
import java.util.List;

public class NhanVienHelper extends SQLiteOpenHelper {
    private List<NhanVien> listNhanVien;
    public NhanVienHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void QueryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    public Cursor GetData(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public List getAllNhanVien (){
        listNhanVien = new ArrayList<>();
        Cursor dataNhanVien = GetData("select * from nhanvien");
        while(dataNhanVien.moveToNext()){
            NhanVien nv = new NhanVien();
            nv.setId(dataNhanVien.getInt(0));
            nv.setName(dataNhanVien.getString(1));

            listNhanVien.add(nv);
        }

        return listNhanVien;
    }
}
