package com.example.vitricongviec2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.vitricongviec2.Adapter.ViTriAdapter;
import com.example.vitricongviec2.DBHelper.ViTriHelper;
import com.example.vitricongviec2.Model.ViTri;

import java.util.ArrayList;
import java.util.List;

public class ViTriActivity extends AppCompatActivity {
    private ListView listView;
    private ViTriAdapter adapter;
    private ViTriHelper helper;
    private List listViTri;
    private Button btnThemViTri;
    private EditText edtName, edtDes;
    private ViTri vt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vi_tri);

        btnThemViTri = findViewById(R.id.btn_themViTri);
        edtName = findViewById(R.id.edt_name);
        edtDes = findViewById(R.id.edt_des);
        listViTri = new ArrayList();
        listView = findViewById(R.id.lv_viTri);
        helper = new ViTriHelper(this, "vtcv.sqlite", null, 1);

        //Tao bang
        helper.Query("create table if not exists vitri(id integer primary key autoincrement, name varchar(255), des varchar(255))");

        //insert
//        helper.Query("insert into vitri values(null, 'Bao ve', '')");

        //Hien Thi
        listViTri = helper.getAllviTri();
        adapter = new ViTriAdapter(listViTri, ViTriActivity.this);
        listView.setAdapter(adapter);

        btnThemViTri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vt = new ViTri();
                vt.setName(String.valueOf(edtName.getText()));
                vt.setDes(String.valueOf(edtDes.getText()));

                helper.addViTri(vt);
                listViTri = helper.getAllviTri();
                adapter.update(listViTri);
            }
        });
    }
}