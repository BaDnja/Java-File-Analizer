package Analizer;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

class GUI extends JFrame {
    GUI() {
        setLayout(new FlowLayout());
        setVisible(true);
        setSize(150, 100);
        setResizable(false);

        JButton fileDialogButton = new JButton();
        fileDialogButton.setText("Open file");
        fileDialogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Txt Files","txt");
                fileChooser.setFileFilter(filter);
                fileChooser.showOpenDialog(GUI.this);
                File file = fileChooser.getSelectedFile();

                Writer writer = new Writer(file.toString());
                writer.write();
            }
        });
        JLabel label = new JLabel("Please open input file!");

        add(fileDialogButton);
        add(label);
    }
}