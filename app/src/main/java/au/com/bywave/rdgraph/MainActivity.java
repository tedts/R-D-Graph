package au.com.bywave.rdgraph;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.LargeValueFormatter;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    BarChart barChart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        float barWidth = 0.3f;
        float barSpace = 0.0f;
        float groupSpace = 0.06f;
        int groupCount = 3;

        barChart = (BarChart) findViewById(R.id.barchart);

        ArrayList xVals = new ArrayList();

        xVals.add("DECEMBER");
        xVals.add("JANUARY");
        xVals.add("FEBRUARY");

        ArrayList openBar = new ArrayList();
        ArrayList resolvedBar = new ArrayList();
        ArrayList unresolvedBar = new ArrayList();

        openBar.add(new BarEntry(1, (float) 1));
        resolvedBar.add(new BarEntry(1, (float) 2));
        unresolvedBar.add(new BarEntry(1, (float) 2));

        openBar.add(new BarEntry(2, (float) 3));
        resolvedBar.add(new BarEntry(2, (float) 4));
        unresolvedBar.add(new BarEntry(2, (float) 4));

        openBar.add(new BarEntry(3, (float) 5));
        resolvedBar.add(new BarEntry(3, (float) 6));
        unresolvedBar.add(new BarEntry(3, (float) 6));

        BarDataSet open, resolved, unresolved;
        open = new BarDataSet(openBar, "OPEN");
        open.setColor(Color.parseColor("#4CAF50"));
        resolved = new BarDataSet(resolvedBar, "RESOLVED");
        resolved.setColor(Color.parseColor("#312B6B"));
        unresolved = new BarDataSet(unresolvedBar, "UNRESOLVED");
        unresolved.setColor(Color.parseColor("#FE0405"));

        BarData data = new BarData(open, resolved, unresolved);
        data.setValueFormatter(new LargeValueFormatter());

        barChart.setData(data);
        barChart.getBarData().setBarWidth(barWidth);
        barChart.getXAxis().setAxisMinimum(0);
        barChart.getXAxis().setAxisMaximum(0 + barChart.getBarData().getGroupWidth(groupSpace, barSpace) * groupCount);
        barChart.groupBars(groupSpace, groupSpace, barSpace);
        barChart.getData().setHighlightEnabled(false);
        barChart.invalidate();

        barChart.setDescription(null);
        barChart.setPinchZoom(false);
        barChart.setScaleEnabled(false);
        barChart.setDrawBarShadow(false);
        barChart.setDrawGridBackground(false);

        Legend l = barChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(true);
        l.setYOffset(20f);
        l.setXOffset(0f);
        l.setYEntrySpace(0f);
        l.setTextSize(8f);

        //X-axis
        XAxis xAxis = barChart.getXAxis();
        xAxis.setGranularity(1f);
        xAxis.setGranularityEnabled(true);
        xAxis.setCenterAxisLabels(true);
        xAxis.setDrawGridLines(false);
        xAxis.setAxisMaximum(3);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(xVals));
        //Y-axis
        barChart.getAxisRight().setEnabled(false);
        YAxis leftAxis = barChart.getAxisLeft();
        leftAxis.setValueFormatter(new LargeValueFormatter());
        leftAxis.setDrawGridLines(true);
        leftAxis.setSpaceTop(35f);
        leftAxis.setAxisMinimum(0f);
    }
}