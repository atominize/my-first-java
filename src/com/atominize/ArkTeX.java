package com.atominize;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

//  This class takes an expression and makes a latex file with the expression as output
public class ArkTeX {
    private String expression;
    private String output = "";

    public ArkTeX(String expression) {
        this.expression = expression;
    }

    public void makeTeXFile() {

    }

    public void openOutputPdf() {
        String currentDir = System.getProperty("user.dir");
        String filePath = currentDir + "/src/com/atominize/output.pdf";
        File file = new File(filePath);
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void execOutput() {
        try {
            String currentDir = System.getProperty("user.dir");
            String filePath = currentDir + "/src/com/atominize";
            ProcessBuilder processBuilder = new ProcessBuilder("pdflatex", "output.tex")
                    .inheritIO().directory(new File(filePath));
            Process process = processBuilder.start();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void readOutputFile() {
        String currentDir = System.getProperty("user.dir");
        String filePath = currentDir + "/src/com/atominize/output.tex";
        File file = new File(filePath);
//        System.out.println(file.getAbsoluteFile().getParent());
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                output += scanner.nextLine() + "\n";
            }
            System.out.println(output);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
