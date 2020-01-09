package StreamsFilesAndDirectories;

import java.io.*;


public class WriteEveryThirdLine {
    public static void main(String[] args) {

        String pathIn = "D:\\Homeworks\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOut = "D:\\Homeworks\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\05.WriteEveryThirdLineOutput.txt";


        try (BufferedReader reader = new BufferedReader(new FileReader(pathIn));
             PrintWriter out = new PrintWriter(new FileWriter(pathOut))) {
            String line = reader.readLine();
            int counter = 1;

            while (line != null) {
                if (counter % 3 == 0) {
                    out.println(line);
                }
                line = reader.readLine();
                counter++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
