package GUI;

import Charts.*;

import javax.swing.*;
import java.awt.*;

class ChartSelection extends JFrame {

    ChartSelection() {
        setLayout(new FlowLayout());
        setVisible(true);
        setSize(400, 100);
        setResizable(false);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int x = (screenSize.width - this.getWidth()) / 2;
        int y = (screenSize.height - this.getHeight()) / 2;
        this.setLocation(x, y);
        setElements();
    }

    private void setElements() {
        JButton fullChart = new JButton("Full Chart");
        JButton uCChart = new JButton("UpperCase Chart");
        JButton lCChart = new JButton("LowerCase Chart");
        JButton dChart = new JButton("Digits Chart");
        JButton sChart = new JButton("Specials Chart");
        add(fullChart);
        add(uCChart);
        add(lCChart);
        add(dChart);
        add(sChart);

        fullChart.addActionListener(actionEvent -> {
            Charts.RecordChart rc = new RecordChart();
        });

        uCChart.addActionListener(actionEvent -> {
            UpperCaseChart ucChart = new UpperCaseChart();
        });

        lCChart.addActionListener(actionEvent -> {
            LowerCaseChart ucChart = new LowerCaseChart();
        });

        dChart.addActionListener(actionEvent -> {
            DigitsChart ucChart = new DigitsChart();
        });

        sChart.addActionListener(actionEvent -> {
            SpecialsChart ucChart = new SpecialsChart();
        });
    }

}
