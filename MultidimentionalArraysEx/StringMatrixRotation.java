package MultidimentionalArraysEx;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        matcher.find();

        int degrees = Integer.parseInt(matcher.group());
        degrees = degrees % 360;

        while (degrees < 0) {
            degrees += 360;
        }

        String command;
        List<String> text = new ArrayList<>();

        while(!"END".equals(command = scanner.nextLine())) {
            text.add(command);
        }

        int maxLength = Integer.MIN_VALUE;

        for (String el : text) {
            if (el.length() > maxLength) {
                maxLength = el.length();
            }
        }

        int initialRows = text.size();
        int initialCols = maxLength;


        if (degrees == 0) {
            char[][] textMatrix = initializeMatrixA(initialRows, initialCols);
            printMatrix(fillMatrix0(text, textMatrix));
        } else if (degrees == 270) {
            char[][] textMatrix = initializeMatrixB(initialRows, initialCols);
            printMatrix(fillMatrix270(text, textMatrix));
        } else if (degrees == 180) {
            char[][] textMatrix = initializeMatrixA(initialRows, initialCols);
            printMatrix(fillMatrix180(text, textMatrix));
        } else if (degrees == 90) {
            char[][] textMatrix = initializeMatrixB(initialRows, initialCols);
            printMatrix(fillMatrix90(text, textMatrix));
        }

    }

    private static void printMatrix(char[][] textMatrix) {
        for (int i = 0; i < textMatrix.length; i++) {
            for (int j = 0; j < textMatrix[i].length; j++) {
                System.out.print(textMatrix[i][j]);
            }
            System.out.println();
        }
    }

    private static char[][] fillMatrix270(List<String> text, char[][] textMatrix) {

        for (int i = 0; i < text.size(); i++) {

            String word = text.get(i);
            int index = textMatrix.length - 1;
            for (int j = 0; j < word.length(); j++) {
                char symbol = word.charAt(j);
                textMatrix[index][i] = symbol;
                index--;
            }
        }

        return textMatrix;
    }

    private static char[][] fillMatrix90(List<String> text, char[][] textMatrix) {
        int index = text.size() - 1;
        int index2 = 0;
        for (int i = 0; i < textMatrix.length; i++) {
            String word = text.get(index);

            for (int j = 0; j < word.length(); j++) {
                char symbol = word.charAt(index2);
                textMatrix[j][i] = symbol;
                    if (index2 + 1 < word.length()) {
                        index2++;
                    } else {
                        index2 = 0;
                        break;
                    }
            }
            index--;
            if (index == -1) {
                break;
            }
        }

        return textMatrix;
    }

    private static char[][] fillMatrix180(List<String> text, char[][] textMatrix) {
        int index = 0;
        int index2 = 0;

        for (int i = textMatrix.length - 1; i >= 0; i--) {
            String word = text.get(index);
            for (int j = textMatrix[i].length - 1; j >= 0; j--) {
                char symbol = word.charAt(index2);
                textMatrix[i][j] = symbol;

                if (index2 + 1 < word.length()) {
                    index2++;
                } else {
                    index2 = 0;
                    break;
                }
            }
            index++;
        }
        return textMatrix;
    }

    private static char[][] fillMatrix0(List<String> text, char[][] textMatrix) {

        for (int i = 0; i < text.size(); i++) {
            String word = text.get(i);
            for (int j = 0; j < word.length(); j++) {
                char symbol = word.charAt(j);
                textMatrix[i][j] = symbol;
            }
        }
        return textMatrix;
    }

    private static char[][] initializeMatrixB(int initialRows, int initialCols) {


        char[][] initMatrix = new char[initialCols][initialRows];

        for (int i = 0; i < initMatrix.length; i++) {
            for (int j = 0; j < initMatrix[i].length; j++) {
                initMatrix[i][j] = ' ';
            }
        }
        return initMatrix;
    }

    private static char[][] initializeMatrixA(int initialRows, int initialCols) {
        char[][] initMatrix = new char[initialRows][initialCols];

        for (int i = 0; i < initMatrix.length; i++) {
            for (int j = 0; j < initMatrix[i].length; j++) {
                initMatrix[i][j] = ' ';
            }
        }

        return initMatrix;
    }
}
