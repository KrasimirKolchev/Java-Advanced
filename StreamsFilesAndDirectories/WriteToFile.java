package StreamsFilesAndDirectories;

import java.io.*;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WriteToFile {
    public static void main(String[] args) {
        String pathIn = "D:\\Homeworks\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathOut = "D:\\Homeworks\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\02.WriteToFileOutput.txt";

        Set<Character> characters = Stream.of('.', ',', '!', '?').collect(Collectors.toSet());

        try (InputStream fis = new FileInputStream(pathIn);
                OutputStream fos = new FileOutputStream(pathOut)) {

            int oneByte = fis.read();

            while (oneByte >= 0) {

                if (!characters.contains((char)oneByte)) {
                    fos.write((char)oneByte);
                }

                oneByte = fis.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
