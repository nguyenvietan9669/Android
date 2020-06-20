package com.example.baitapcuoikitt;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Spinner spinnerds,spinner;
    Button chuyen,quydoi;
    EditText sotien;
    TextView tVketqua;
    int i,y;
    double VND,tienNN,ketqua;
    String ten,ten1;
    ArrayList<QuocGia> arrayList;
    ArrayList<QuocGia> arrayList1;
    QuocGiaAdapter quocGiaAdapter;
    QuocGiaAdapter quocGiaAdapter1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        quocGiaAdapter = new QuocGiaAdapter(this,R.layout.dong_quocgia,arrayList);
        spinnerds.setAdapter(quocGiaAdapter);
        quocGiaAdapter1 = new QuocGiaAdapter(this,R.layout.dong_quocgia,arrayList1);
        spinner.setAdapter(quocGiaAdapter1);
        chuyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               spinner.setSelection(y);
               spinnerds.setSelection(i);
            }
        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ten1 = arrayList.get(position).getTen();
                i = position;
                if(ten1 == "USD" )
                {
                    VND = 23245.21;
                }
                if(ten1 == "EUR")
                {
                    VND = 26232.22;
                }
                if(ten1 == "KRW")
                {
                    VND = 19.16;
                }
                if(ten1 == "JPY")
                {
                    VND = 212.36;
                }
                if(ten1 == "CNY")
                {
                    VND = 3285.05;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinnerds.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ten = arrayList1.get(position).getTen();
                y = position;
                if(ten == "USD" )
                {
                    tienNN = 0.000043;
                }
                if(ten == "EUR")
                {
                    tienNN = 0.000038;
                }
                if(ten == "KRW")
                {
                    tienNN = 0.05152;
                }
                if(ten == "JPY")
                {
                    tienNN = 0.004657;
                }
                if(ten == "CNY")
                {
                    tienNN = 0.00030;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Ketqua();
    }
    private void Anhxa() {
        tVketqua = (TextView) findViewById(R.id.txtKetqua);
        sotien = (EditText) findViewById(R.id.sotien);
        chuyen =(Button) findViewById(R.id.doi);
        quydoi = (Button) findViewById(R.id.quydoi);
        spinnerds = (Spinner) findViewById(R.id.spinner);
        spinner = (Spinner) findViewById(R.id.spinner1);
        arrayList = new ArrayList<QuocGia>();
        arrayList.add(new QuocGia(R.drawable.china,"CNY"));
        arrayList.add(new QuocGia(R.drawable.japan,"JPY"));
        arrayList.add(new QuocGia(R.drawable.eur,"EUR"));
        arrayList.add(new QuocGia(R.drawable.korea,"KRW"));
        arrayList.add(new QuocGia(R.drawable.usa,"USD"));
        arrayList1= new ArrayList<QuocGia>();
        arrayList1.add(new QuocGia(R.drawable.china,"CNY"));
        arrayList1.add(new QuocGia(R.drawable.japan,"JPY"));
        arrayList1.add(new QuocGia(R.drawable.eur,"EUR"));
        arrayList1.add(new QuocGia(R.drawable.korea,"KRW"));
        arrayList1.add(new QuocGia(R.drawable.usa,"USD"));
    }
    private void Ketqua()
    {
        quydoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String value = sotien.getText().toString();
                    int kiemtranhap = sotien.length();
                if(kiemtranhap == 0)
                {
                    Toast.makeText(MainActivity.this,"Mời nhập số tiền cần chuyển đổi",Toast.LENGTH_LONG).show();
                }
                if(kiemtranhap != 0) {
                    double tien = Double.parseDouble(value);
                    ketqua = tien * VND * tienNN;
                    String gan = String.valueOf(ketqua);
                    String inra = value +" " + ten1 + " : " + gan + " = " + ten;
                    tVketqua.setText(inra);
                }
            }
        });
    }
}
