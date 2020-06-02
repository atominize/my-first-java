package com.atominize;

import java.awt.*;
import java.io.*;
import java.util.Scanner;

//  This class takes an expression and makes a latex file with the expression as output
public class ArkTeX {
    private String function;
    private String derivative;
    private String showWork;
    private boolean isShowWorkEnable;
    private String output = "";

    public ArkTeX(String function, String derivative) {
        this.function = function;
        this.derivative = derivative;
        this.isShowWorkEnable = false;
    }

    public ArkTeX(String function, String derivative, String showWork) {
        this.function = function;
        this.derivative = derivative;
        this.showWork = showWork;
        this.isShowWorkEnable = true;
    }

    public void start() {
        convertOutputTexToString();
        getNewOutputString();
        writeToOutputTex();
        execOutput("newOutput");
        openOutputPdf();
    }

    private void getNewOutputString() {
        String replacement = "{LARGE}\n The differentiation of $$" + convertFuncToTex(function)
                + " $$ is \n\n" + "$$ " + convertFuncToTex(derivative) + " $$ ." + "\n\\end{LARGE}";
        if (isShowWorkEnable) {
            replacement = "{Large}" + showWork + "\\end{Large}";
        }
        String[]  outputs = output.split("\\{Large}");
        output = outputs[0] + replacement + outputs[2];
    }

// 2x^3 + exp(x^4)
    private String convertFuncToTex(String function) {
        return function.replace("exp(", "e^{")
                .replace(")", "}");
    }

    private void openOutputPdf() {
        String currentDir = System.getProperty("user.dir");
        String filePath = currentDir + "/src/com/atominize/newOutput.pdf";
        File file = new File(filePath);
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void execOutput(String output) {
        try {
            String currentDir = System.getProperty("user.dir");
            String filePath = currentDir + "/src/com/atominize";
            ProcessBuilder processBuilder = new ProcessBuilder("pdflatex", output + ".tex")
                    .inheritIO().directory(new File(filePath));
            Process process = processBuilder.start();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void writeToOutputTex() {
        String currentDir = System.getProperty("user.dir");
        String filePath = currentDir + "/src/com/atominize/newOutput.tex";
        File file = new File(filePath);
//        System.out.println(output);
        byte[] b = output.getBytes();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            int i = 0;
            while (i < b.length) {
                fileOutputStream.write(b[i]);
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void convertOutputTexToString() {
        String currentDir = System.getProperty("user.dir");
        String filePath = currentDir + "/src/com/atominize/output.tex";
        File file = new File(filePath);
//        System.out.println(file.getAbsoluteFile().getParent());
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                output += scanner.nextLine() + "\n";
            }
//            System.out.println(output);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
