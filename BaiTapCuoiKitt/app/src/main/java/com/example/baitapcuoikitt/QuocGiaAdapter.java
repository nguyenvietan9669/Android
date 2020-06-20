package com.example.baitapcuoikitt;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;

import java.util.Dictionary;
import java.util.List;

public class QuocGiaAdapter extends BaseAdapter {
    Context context;
    int mylayout;
    List<QuocGia> quocGia;

    public QuocGiaAdapter(Context context, int mylayout, List<QuocGia> quocGia) {
        this.context = context;
        this.mylayout = mylayout;
        this.quocGia = quocGia;
    }

    @Override
    public int getCount() {
        return quocGia.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(mylayout,null);
        TextView txtName = (TextView) convertView.findViewById(R.id.txtName);
        ImageView imageHinh =(ImageView) convertView.findViewById(R.id.imageHinh);
        QuocGia qG = quocGia.get(position);
        txtName.setText(qG.getTen());
        imageHinh.setImageResource(qG.getHinh());
        return convertView;
    }
}
