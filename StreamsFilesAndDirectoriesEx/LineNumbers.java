package StreamsFilesAndDirectoriesEx;

import java.io.*;

public class LineNumbers {
    public static void main(String[] args) {

        String pathIn = "D:\\Homeworks\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        String pathOut = "D:\\Homeworks\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(pathIn));
             PrintWriter out = new PrintWriter(pathOut)) {

            String line;
            int count = 1;
            while ((line = br.readLine()) != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(count).append(". ").append(line);
                out.println(sb.toString());
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
