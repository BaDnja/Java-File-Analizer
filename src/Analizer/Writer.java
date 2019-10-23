package Analizer;
import GUI.MainGUI;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.List;

public class Writer {

    private String currentFileName;
    private String fileName;
    private BufferedWriter writer;

    /**
     * @param file - name of the current file.
     * @throws IOException - if file is missing.
     */
    public Writer(String file) throws IOException {
        currentFileName = file;
        fileName = getFilePath(MainGUI.currentFile) + "\\stats_" + MainGUI.currentFile.getName();
        writer = new BufferedWriter(new FileWriter(fileName));
    }

    /**
     * @throws IOException - if file is missing.
     * Method that writes statistics to a file.
     */
    public void write() throws IOException {
        TxtAnalizer txtAnalizer = new TxtAnalizer();
        long startTime = System.currentTimeMillis();
        List<Map<Character, Integer>> mapList = txtAnalizer.analyze(currentFileName);
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());

        writeContent("-------------------");
        writeContent("File analyzed: " + MainGUI.currentFile.getName());
        writeContent("File Path: " + MainGUI.currentFile);
        writeContent("Analysis time: " + executionTime + " milliseconds");
        writeContent("Executed at: " + formatter.format(date));
        writeContent("-------------------");
        writeContent("\nFILE STATISTICS: " + "\n");

        if (!mapList.isEmpty()) {
            for (Map<Character, Integer> map : mapList) {
                Map.Entry<Character, Integer> entry = map.entrySet().iterator().next();
                if (Character.isUpperCase(entry.getKey())) {
                    //System.out.println("\nUpperCase: " + map);
                    writeContent("UpperCase Characters: " + map.toString() + "\n");
                } else if (Character.isLowerCase(entry.getKey())) {
                    //System.out.println("\nLowerCase: " + map);
                    writeContent("LowerCase Characters: " + map.toString() + "\n");
                } else if (Character.isDigit(entry.getKey())) {
                    //System.out.println("\nDigits: " + map);
                    writeContent("Digits: " + map.toString() + "\n");
                } else {
                    //System.out.println("\nSpecials: " + map);
                    writeContent("Special Characters: " + map.toString());
                }
            }
            writeContent("-------------------");
        }

        closeWriter();
        JOptionPane.showMessageDialog(null, "Statistics successfully written to a file!\n" +
                "File is stored at the input file location.\n" +
                "Name of the file is stats_" + MainGUI.currentFile.getName());
    }

    /**
     * @param content - String representing the content to be written.
     * @throws IOException - if file is missing.
     */
    private void writeContent(String content) throws IOException {
        this.writer.write(content + "\n");
    }

    /**
     * @throws IOException - if file is missing.
     * Closes writer to prevent memory leak.
     */
    private void closeWriter() throws IOException {
        this.writer.close();
    }

    /**
     * @param file - current file as File.
     * @return - String representing current file path.
     */
    private String getFilePath(File file) {
        return file.getAbsoluteFile().getParent();
    }
}