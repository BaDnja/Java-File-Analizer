package GUI;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;

public class MainGUI extends JFrame {
    public static File currentFile;

    public MainGUI() {
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
        fileDialogButton.addActionListener(actionEvent -> {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Txt Files","txt");
            fileChooser.setFileFilter(filter);
            fileChooser.showOpenDialog(MainGUI.this);

            try {
                currentFile = fileChooser.getSelectedFile();
                ChartSelection cs = new ChartSelection();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No file chosen.");
            }
        });
        JLabel label = new JLabel("Please open input file!");

        add(fileDialogButton);
        add(label);
    }
}