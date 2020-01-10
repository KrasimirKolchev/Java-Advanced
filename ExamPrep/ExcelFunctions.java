package ExamPrep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExcelFunctions {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        String[][] sheet = new String[n][];

        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split(",\\s+");
            sheet[i] = line;
        }

        String[] command = reader.readLine().split("\\s+");
        String value;

        switch (command[0]) {

            case "hide":
                value = command[1];
                //System.out.println(headerPrint);
                hideColumn(sheet, value);
                break;
            case "sort":
                value = command[1];
                sortSheet(sheet, value);
                break;
            case "filter":
                value = command[1];
                String value2 = command[2];
                //System.out.println(headerPrint);
                filterSheet(sheet, value, value2);
                break;
        }


        System.out.println();
    }

    private static void headerPrint(String[][] sheet) {
        StringBuilder header = new StringBuilder();

        for (int i = 0; i < sheet[0].length; i++) {
            header.append(sheet[0][i]);
            header.append(" ");
        }
        System.out.println(header.toString().trim().replaceAll(" ", " | "));
    }

    private static void filterSheet(String[][] sheet, String value, String value2) {
        int index = 0;

        for (int i = 0; i < sheet[0].length; i++) {
            if (sheet[0][i].equals(value)) {
                index = i;
                break;
            }
        }
        headerPrint(sheet);
        for (int i = 1; i < sheet.length; i++) {
            StringBuilder sb = new StringBuilder();

            if (sheet[i][index].equals(value2)) {
                for (int j = 0; j < sheet[0].length; j++) {
                    sb.append(sheet[i][j]);
                    sb.append(" ");
                }

                System.out.println(sb.toString().trim().replaceAll(" ", " | "));
            }
        }
    }

    private static void sortSheet(String[][] sheet, String value) {
        int index = 0;

        for (int i = 0; i < sheet[0].length; i++) {
            if (sheet[0][i].equals(value)) {
                index = i;
                break;
            }
        }

        List<String> values = new ArrayList<>();

        for (int i = 1; i < sheet.length; i++) {
            values.add(sheet[i][index]);
        }

        Collections.sort(values);
        headerPrint(sheet);

        for (int i = 0; i < values.size(); i++) {
            for (int j = 0; j < sheet.length; j++) {

                if (sheet[j][index].equals(values.get(i))) {
                    StringBuilder sb = new StringBuilder();
                    for (int k = 0; k < sheet[0].length; k++) {
                        sb.append(sheet[j][k]);
                        sb.append(" ");
                    }
                    System.out.println(sb.toString().trim().replaceAll(" ", " | "));
                }
            }
        }
    }

    private static void hideColumn(String[][] sheet ,String value) {
        int index = 0;

        for (int i = 0; i < sheet[0].length; i++) {
            if (sheet[0][i].equals(value)) {
                index = i;
                break;
            }
        }

        for (int i = 0; i < sheet.length; i++) {
            sheet[i][index] = "";
        }

        for (int i = 0; i < sheet.length; i++) {
            StringBuilder sb = new StringBuilder();


            for (int j = 0; j < sheet[i].length; j++) {
                if (j != index) {
                    sb.append(sheet[i][j]);
                    sb.append(" ");
                }
            }
            System.out.println(sb.toString().trim().replaceAll(" ", " | "));

        }
    }

}
