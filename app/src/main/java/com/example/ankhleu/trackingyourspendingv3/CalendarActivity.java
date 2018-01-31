package com.example.ankhleu.trackingyourspendingv3;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.Toast;

/**
 * Created by ankhleu on 2018/1/31.
 */

public class CalendarActivity extends Activity {


    public CalendarView calendarView;
    public int Currentyear, Currentmonth,Currentdate;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_bill);

        calendarView = (CalendarView) findViewById(R.id.calendarView);
        //日期改變的时候啟動listener
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {
                Toast.makeText(getApplicationContext(), "選擇的日期是 : " + Currentyear +"年"
                        + Currentmonth + " 月 " + Currentdate + "日", Toast.LENGTH_LONG).show();


            }
        });
    }

}
