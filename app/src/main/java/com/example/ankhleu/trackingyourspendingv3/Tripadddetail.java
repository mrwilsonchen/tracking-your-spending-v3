package com.example.ankhleu.trackingyourspendingv3;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.example.ankhleu.trackingyourspendingv3.tripdata.tripadd_constructor;



public class Tripadddetail extends AppCompatActivity {

    TextView tv1 ; //時間
    EditText ed1,ed2; //金額 註記
    Spinner sp1,sp2; //項目 幣別
    private int mYear, mMonth, mDay;//時間單位
    public String time ;

    public void time(String time)
    {
        this.time=time;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tripadddetail);
        tv1 = findViewById(R.id.textView);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dt = new Date();
        String dts = sdf.format(dt);
        tv1.setText(dts);  //預設是顯示當下時間

        sp1 = findViewById(R.id.pick);
        ArrayAdapter<CharSequence> objList = ArrayAdapter.createFromResource(this,
                R.array.subject,android.R.layout.simple_list_item_1);
        sp1.setAdapter(objList); //把值帶入

        sp2 = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> curList = ArrayAdapter.createFromResource(this,
                R.array.currency,android.R.layout.simple_list_item_1);
        sp2.setAdapter(curList);
    }
    public void clicktime(View v) //改時間
    {
        showDatePickerDialog();
    }
    public void showDatePickerDialog() {
        // 設定初始日期
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        // 跳出日期選擇器
        DatePickerDialog dpd = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        // 完成選擇，顯示日期
                        tv1.setText(year + "-" + (monthOfYear + 1) + "-"
                                + dayOfMonth);

                    }
                }, mYear, mMonth, mDay);
        dpd.show();


    }
    public void clickgo(View v)
    {
        ed1 = findViewById(R.id.editText7);
        ed2 = findViewById(R.id.editText3);
        tv1 = findViewById(R.id.textView);
        sp1 = findViewById(R.id.pick);
        sp2 = findViewById(R.id.spinner2);
//        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {  //監聽他選了哪個
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });

        int money = Integer.valueOf(ed1.getText().toString());
        String note = ed2.getText().toString();
        //String time = tv1.getText().toString();  //抓時間很奇怪
        time = tv1.getText().toString();  //抓時間很奇怪
        String subject =sp1.getSelectedItem().toString();
        String Currency =sp2.getSelectedItem().toString();

        MainActivity.dao2.add(new tripadd_constructor(time,money,subject,Currency,note));
        finish();
    }
    public void clickno(View v)
    {
        finish();
    }
}
