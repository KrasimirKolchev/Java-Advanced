package StreamsFilesAndDirectories;

import java.io.*;

public class CopyBytes {
    public static void main(String[] args) {

        String pathIn = "D:\\Homeworks\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOut = "D:\\Homeworks\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\03.CopyBytesOutput.txt";

        try (FileInputStream fis = new FileInputStream(pathIn);
             FileOutputStream fos = new FileOutputStream(pathOut)) {

            int oneByte = 0;

            while ((oneByte = fis.read()) >= 0) {
                if (oneByte == 10 || oneByte == 32) {
                    fos.write(oneByte);
                } else {
                    String digits = String.valueOf(oneByte);
                    for (int i = 0; i < digits.length(); i++) {
                        fos.write(digits.charAt(i));
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
