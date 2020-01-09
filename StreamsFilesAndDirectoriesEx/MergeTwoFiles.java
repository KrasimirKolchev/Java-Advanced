package StreamsFilesAndDirectoriesEx;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class MergeTwoFiles {
    public static void main(String[] args) {

        String pathIn = "D:\\Homeworks\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String pathIn2 = "D:\\Homeworks\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";
        String pathOut = "D:\\Homeworks\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(pathIn));
             BufferedReader br2 = new BufferedReader(new FileReader(pathIn2));
             PrintWriter out = new PrintWriter(pathOut)) {

            StringBuilder sb = new StringBuilder();
            String line1;

            while ((line1 = br.readLine()) != null) {
                sb.append(line1).append(System.lineSeparator());
            }

            String line2;
            while ((line2 = br2.readLine()) != null) {
                sb.append(line2).append(System.lineSeparator());
            }

            out.println(sb.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
