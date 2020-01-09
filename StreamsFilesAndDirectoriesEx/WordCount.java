package StreamsFilesAndDirectoriesEx;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class WordCount {
    public static void main(String[] args) {

        String pathIn = "D:\\Homeworks\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        String pathIn2 = "D:\\Homeworks\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
        String pathOut = "D:\\Homeworks\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\result.txt";

        List<String> words = new ArrayList<>();
        Map<String, Integer> wordsCount = new LinkedHashMap<>();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(pathIn))) {
            while ((line = br.readLine()) != null) {
                Collections.addAll(words, line.split("\\s+"));
            }

            for (String word : words) {
                wordsCount.put(word, 0);
            }

            try (BufferedReader br2 = new BufferedReader(new FileReader(pathIn2));
                 PrintWriter out = new PrintWriter(pathOut)) {
                List<String> text = new ArrayList<>();
                while ((line = br2.readLine()) != null) {
                    line = line.replaceAll(".|,|!|\\?", "");
                    Collections.addAll(text, line.split("\\s+"));
                }

                for (String item : text) {
                    if (words.contains(item)) {
                        wordsCount.put(item, wordsCount.get(item) + 1);
                    }
                }

                wordsCount.entrySet().stream().sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                        .forEach(e -> out.println(String.format("%s - %d", e.getKey(), e.getValue())));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
