package com.example.ankhleu.trackingyourspendingv3;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * Created by ankhleu on 2018/1/31.
 */

public class AnalysisActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_analysis);
////////////////////////////////////////////////////////
        PieChart pieChart = (PieChart) findViewById(R.id.piechart);
        pieChart.setUsePercentValues(true);

////////////////////////////////////////////////////////↓設資料，val為值，以下加總為100%，加總非100會算比例
        ArrayList<Entry> yvalues = new ArrayList<Entry>();
        yvalues.add(new Entry(8f, 0));
        yvalues.add(new Entry(15f, 1));
        yvalues.add(new Entry(12f, 2));
        yvalues.add(new Entry(25f, 3));
        yvalues.add(new Entry(23f, 4));
        yvalues.add(new Entry(17f, 5));

        PieDataSet dataSet = new PieDataSet(yvalues, "Election Results");

////////////////////////////////////////////////////////↓設各個數值的名稱
        ArrayList<String> xVals = new ArrayList<String>();

        xVals.add("January");
        xVals.add("February");
        xVals.add("March");
        xVals.add("April");
        xVals.add("May");
        xVals.add("June");

        PieData data = new PieData(xVals, dataSet);


        // In percentage Term
        data.setValueFormatter(new PercentFormatter());
        // Default value
        //data.setValueFormatter(new DefaultValueFormatter(0));

        pieChart.setData(data);

/////////////////////////////////////////////////////////////顏色 ↓

        dataSet.setColors(ColorTemplate.VORDIPLOM_COLORS);

        dataSet.setColors(ColorTemplate.JOYFUL_COLORS);

        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        dataSet.setColors(ColorTemplate.LIBERTY_COLORS);

        dataSet.setColors(ColorTemplate.PASTEL_COLORS);



        pieChart.setDescription("This is Pie Chart"); //右下 標語

        //Disable Hole in the Pie Chart
        pieChart.setDrawHoleEnabled(true); // 圓餅中間要不要有洞


        pieChart.setTransparentCircleRadius(30f);
        pieChart.setHoleRadius(30f); //中間圓洞的半徑

        data.setValueTextSize(17f); //名稱的字體大小
        data.setValueTextColor(Color.DKGRAY);//字的顏色

        pieChart.animateXY(1400, 1400); //跑動畫用，要直接秀出來就刪掉這行  ，引數1是圓餅跑出來的時間，引數2是字跑出來的時間

        pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener()
        {//设置值选择时的Listener
            @Override
            public void onValueSelected(Entry entry, int i, Highlight highlight)
            {
                Toast.makeText(AnalysisActivity.this, "Something selected value = " + entry.getVal(), Toast.LENGTH_SHORT).show();//单纯地显示一个Toast
            }
            @Override
            public void onNothingSelected() {
            }
        });
    }
}
