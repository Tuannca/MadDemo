package com.example.vitricongviec2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.vitricongviec2.Model.NhanVien;
import com.example.vitricongviec2.R;

import java.util.List;

public class NhanVienAdapter extends BaseAdapter {
    private List<NhanVien> listNhanVien;
    private Context context;

    public NhanVienAdapter(List<NhanVien> listNhanVien, Context context) {
        this.listNhanVien = listNhanVien;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listNhanVien.size();
    }

    @Override
    public Object getItem(int position) {
        return listNhanVien.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listNhanVien.get(position).getId();
    }
    private class ViewHolder{
        TextView tv_name;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder viewHolder;
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.nhanvien_item, null);

            viewHolder = new ViewHolder();
            viewHolder.tv_name = view.findViewById(R.id.tv_name);

            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        NhanVien nv = listNhanVien.get(position);
        viewHolder.tv_name.setText(nv.getId() + ".  " + nv.getName());
        return view;
    }
    public void update(List<NhanVien> newlist) {
        listNhanVien.clear();
        listNhanVien.addAll(newlist);
        this.notifyDataSetChanged();
    }
}
