package Charts;

import GUI.MainGUI;
import Analizer.TxtAnalizer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.ChartFrame;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RecordChart {
    public RecordChart() {
        showChart();
    }

    private void showChart() {
        DefaultCategoryDataset dcd = new DefaultCategoryDataset();

        // Add dynamic data
        TxtAnalizer txtAnalizer = new TxtAnalizer();
        List<Map<Character, Integer>> mapList = txtAnalizer.analyze(MainGUI.currentFile.toString());
        if (!mapList.isEmpty()) {
            for (Map<Character, Integer> map : mapList) {
                Map.Entry<Character, Integer> entry = map.entrySet().iterator().next();
                Set characterSet = map.keySet();
                Iterator iterator = characterSet.iterator();
                if (Character.isUpperCase(entry.getKey())) {
                    while (iterator.hasNext()) {
                        Character key = (Character) iterator.next();
                        Integer value = map.get(key);
                        dcd.setValue(value, "UpperCase", key);
                    }
                } else if (Character.isLowerCase(entry.getKey())) {
                    while (iterator.hasNext()) {
                        Character key = (Character) iterator.next();
                        Integer value = map.get(key);
                        dcd.setValue(value, "LowerCase", key);
                    }
                } else if (Character.isDigit(entry.getKey())) {
                    while (iterator.hasNext()) {
                        Character key = (Character) iterator.next();
                        Integer value = map.get(key);
                        dcd.setValue(value, "Digit", key);
                    }
                } else {
                    while (iterator.hasNext()) {
                        Character key = (Character) iterator.next();
                        Integer value = map.get(key);
                        dcd.setValue(value, "Special", key);
                    }
                }
            }
        }

        JFreeChart chart = ChartFactory.createBarChart3D("File Statistics", "Character",
                "Value", dcd, PlotOrientation.VERTICAL, true, true, false);

        CategoryPlot plot = chart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.black);
        ChartFrame chartFrm = new ChartFrame("Record", chart, true);
        chartFrm.setVisible(true);
        chartFrm.setSize(640, 490);

    }
}