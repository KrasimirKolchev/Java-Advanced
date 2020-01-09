package StreamsFilesAndDirectoriesEx;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountCharacterTypes {
    public static void main(String[] args) {

        String pathIn = "D:\\Homeworks\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String pathOut = "D:\\Homeworks\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

        List<Character> vowels = new ArrayList<>();
        Collections.addAll(vowels,'a', 'e', 'i', 'o', 'u');
        List<Character> consonants = new ArrayList<>();
        Collections.addAll(consonants,
                'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','y','z');
        List<Character> punctuation = new ArrayList<>();
        Collections.addAll(punctuation,'.', ',', '!', '?');

        try (BufferedReader reader = new BufferedReader(new FileReader(pathIn));
             PrintWriter out = new PrintWriter(pathOut)) {
            int vowelCount = 0;
            int consonantCount = 0;
            int punctCount = 0;

            String line;


            while ((line = reader.readLine()) != null) {

                for (int i = 0; i < line.length(); i++) {
                    char symbol = line.charAt(i);

                    if (punctuation.contains(symbol)) {
                        punctCount++;
                    } else if (vowels.contains(symbol)) {
                        vowelCount++;
                    } else if (consonants.contains(symbol)) {
                        consonantCount++;
                    } else if (symbol != ' ') {
                        consonantCount++;
                    }
                }
            }

            out.println(String.format("Vowels: %d%nConsonants: %d%nPunctuation: %d%n",
                    vowelCount, consonantCount, punctCount));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
