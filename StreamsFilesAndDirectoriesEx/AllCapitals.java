package StreamsFilesAndDirectoriesEx;

import java.io.*;

public class AllCapitals {
    public static void main(String[] args) {

        String pathIn = "D:\\Homeworks\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String pathOut = "D:\\Homeworks\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(pathIn));
             PrintWriter out = new PrintWriter(pathOut)) {

            String line;
            while ((line = reader.readLine()) != null) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < line.length(); i++) {
                    int symbol = line.charAt(i);
                    if (symbol >= 95 && symbol <= 122) {
                        sb.append((char)(symbol - 32));
                    } else {
                        sb.append((char)symbol);
                    }
                }
                out.println(sb.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
