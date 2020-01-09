package StreamsFilesAndDirectories;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class NestedFiles {
    public static void main(String[] args) {

        String path = "D:\\Homeworks\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";
        File root = new File(path);

        Deque<File> dir = new ArrayDeque<>();
        dir.offer(root);

        int count = 0;

        while (!dir.isEmpty()) {
            File current = dir.poll();
            if (current != null) {
                File[] nestedFiles = current.listFiles();

                for (File nested : nestedFiles) {
                    if (nested.isDirectory()) {
                        dir.offer(nested);
                    }
                }
                count++;
                System.out.println(current.getName());
            }
        }
        System.out.println(count + " folders");
    }
}
