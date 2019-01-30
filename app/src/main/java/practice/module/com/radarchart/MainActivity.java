package practice.module.com.radarchart;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RadarChart radarChart;
    String[] labels = {"Chest","Shoulders","Legs","Back and Abs","Arms"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radarChart = findViewById(R.id.radarChart);

        RadarDataSet dataSet1 = new RadarDataSet(dataValues1(),"Yesterday");
        RadarDataSet dataSet2 = new RadarDataSet(dataValues2(),"Today");

        dataSet1.setColor(Color.RED);
        dataSet2.setColor(Color.BLUE);

        radarChart.setBackgroundColor(Color.rgb(60,65,82));
        radarChart.getDescription().setEnabled(false);
        radarChart.setWebLineWidth(1f);

        radarChart.setWebColor(Color.WHITE);
        radarChart.setWebLineWidth(1f);
        radarChart.setWebColorInner(Color.WHITE);
        radarChart.setWebAlpha(100);

        RadarData data = new RadarData();
        data.addDataSet(dataSet1);
        data.addDataSet(dataSet2);

        XAxis xAxis = radarChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));
        xAxis.setTextSize(9f);
        xAxis.setXOffset(0);
        xAxis.setYOffset(0);
        xAxis.setTextColor(Color.WHITE);

        //for reducing the size of chart

//        YAxis yAxis = radarChart.getYAxis();
//        yAxis.setLabelCount(5);
//        yAxis.setTextSize(9f);
//        yAxis.setAxisMaximum(12);
//        yAxis.setAxisMinimum(1f);
//        yAxis.setDrawLabels(false);

        //for hiding legend , axis description
        radarChart.getLegend().setEnabled(false);
        radarChart.setSkipWebLineCount(0);
        radarChart.setData(data);
        radarChart.invalidate();

    }

    private ArrayList<RadarEntry> dataValues1(){
        ArrayList<RadarEntry> dataVals = new ArrayList<>();
        dataVals.add(new RadarEntry(7));
        dataVals.add(new RadarEntry(5));
        dataVals.add(new RadarEntry(8));
        dataVals.add(new RadarEntry(2));
        dataVals.add(new RadarEntry(6));
        return dataVals;
    }

    private ArrayList<RadarEntry> dataValues2(){
        ArrayList<RadarEntry> dataVals = new ArrayList<>();
        dataVals.add(new RadarEntry(4));
        dataVals.add(new RadarEntry(2));
        dataVals.add(new RadarEntry(5));
        dataVals.add(new RadarEntry(7));
        dataVals.add(new RadarEntry(4));
        return dataVals;
    }
}
