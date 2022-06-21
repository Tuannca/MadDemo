package com.example.vitricongviec2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.vitricongviec2.Model.ViTri;
import com.example.vitricongviec2.R;

import java.util.List;

public class ViTriAdapter extends BaseAdapter {
    private List<ViTri> listViTri;
    private Context context;

    public ViTriAdapter(List<ViTri> listViTri, Context context) {
        this.listViTri = listViTri;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listViTri.size();
    }

    @Override
    public Object getItem(int position) {
        return listViTri.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listViTri.get(position).getId();
    }
    private class ViewHolder{
        TextView tvName;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.vitri_item, null);
            viewHolder = new ViewHolder();
            viewHolder.tvName = convertView.findViewById(R.id.tv_name);

            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        ViTri vt = listViTri.get(position);
        viewHolder.tvName.setText(vt.getId() + ". " + vt.getName());
        return convertView;
    }
    public void update (List newList){
        listViTri.clear();
        listViTri.addAll(newList);
        this.notifyDataSetChanged();
    }
}
