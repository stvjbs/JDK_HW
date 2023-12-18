package server;

import java.io.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FileWorker {
    static File file = new File("logFile.txt");

    public static void logWriter(String s) {
        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write(s + "\n");
            fw.flush();
        } catch (IOException e) {
            System.out.println("No log");
        }
    }

    public static List<String> logReader() {
        List<String> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String s;
            while ((s = br.readLine()) != null) {
                result.add(s);
            }
            return result;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

}
