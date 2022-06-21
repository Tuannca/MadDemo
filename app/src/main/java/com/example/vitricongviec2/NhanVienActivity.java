package com.example.vitricongviec2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.vitricongviec2.Adapter.NhanVienAdapter;
import com.example.vitricongviec2.DBHelper.NhanVienHelper;
import com.example.vitricongviec2.Model.NhanVien;

import java.util.ArrayList;
import java.util.List;

public class NhanVienActivity extends AppCompatActivity {
    private ListView listView;
    private Button btnThemNhanVien;
    private List<NhanVien> listNhanVien;
    private NhanVienAdapter adapter;
    private NhanVienHelper helper;
    private NhanVien nv;
    private EditText edtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhan_vien);

        edtName = findViewById(R.id.edt_name);
        btnThemNhanVien = findViewById(R.id.btn_themNhanVien);
        listView =findViewById(R.id.lv_nhanVien);
        listNhanVien = new ArrayList<>();

        adapter = new NhanVienAdapter(listNhanVien, NhanVienActivity.this);
        listView.setAdapter(adapter);
        //Tao db
        helper = new NhanVienHelper(NhanVienActivity.this, "vtcv.sqlite", null, 1);
        //Tao bang
        helper.QueryData("create table if not exists nhanvien(id integer primary key autoincrement, name varchar(255))");

        //Them data
//        helper.QueryData("insert into nhanvien values(null, 'Nguyen Van C')");

        //Hien thi
        listNhanVien = helper.getAllNhanVien();
        adapter.update(listNhanVien);
//        adapter.notifyDataSetChanged();
//        System.out.println("-------------" + listNhanVien.size());

        btnThemNhanVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(NhanVienActivity.this, ThemNhanVienActivity.class);
//                startActivity(intent);

                String name = String.valueOf(edtName.getText());
                helper.QueryData("insert into nhanvien values(null, '" + name + "')");

                listNhanVien = helper.getAllNhanVien();
                adapter.update(listNhanVien);

            }
        });
    }
}