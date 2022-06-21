package com.example.vitricongviec2.DBHelper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.vitricongviec2.Model.ViTri;

import java.util.ArrayList;
import java.util.List;

public class ViTriHelper extends SQLiteOpenHelper {
    public ViTriHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public void Query(String sql){
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
    public List getAllviTri (){
        List<ViTri> listViTri = new ArrayList<>();
        Cursor dataViTri = GetData("select * from vitri");
        while(dataViTri.moveToNext()){
            ViTri vt = new ViTri();
            vt.setId(dataViTri.getInt(0));
            vt.setName(dataViTri.getString(1));
            vt.setDes(dataViTri.getString(2));

            listViTri.add(vt);
        }
        return listViTri;
    }
    public void addViTri (ViTri vt){
        Query("insert into vitri values(null, '"+ vt.getName() +"', '"+ vt.getDes() +"')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
