package Analizer;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

class GUI extends JFrame {
    public static File currentFile;

    GUI() {
        setLayout(new FlowLayout());
        setVisible(true);
        setSize(150, 100);
        setResizable(false);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int x = (screenSize.width - this.getWidth()) / 2;
        int y = (screenSize.height - this.getHeight()) / 2;
        this.setLocation(x, y);

        JButton fileDialogButton = new JButton();
        fileDialogButton.setText("Open file");
        fileDialogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Txt Files","txt");
                fileChooser.setFileFilter(filter);
                fileChooser.showOpenDialog(GUI.this);

                try {
                    File file = fileChooser.getSelectedFile();
                    currentFile = file;
                    RecordChart c = new RecordChart();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "No file chosen.");
                }
            }
        });
        JLabel label = new JLabel("Please open input file!");

        add(fileDialogButton);
        add(label);
    }
}