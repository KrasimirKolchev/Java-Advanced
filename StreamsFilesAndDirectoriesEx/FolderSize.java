package StreamsFilesAndDirectoriesEx;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class FolderSize {
    public static void main(String[] args) {

        String path = "D:\\Homeworks\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";
        File root = new File(path);

        Deque<File> dir = new ArrayDeque<>();
        dir.offer(root);

        long size = 0;

        while (!dir.isEmpty()) {
            File current = dir.poll();
            if (current != null) {
                File[] nestedFiles = current.listFiles();

                for (File nested : nestedFiles) {
                    if (nested.isDirectory()) {
                        dir.offer(nested);
                    } else {
                        size += nested.length();
                    }
                }

            }
        }
        System.out.println("Folder size: " + size);
    }
}
