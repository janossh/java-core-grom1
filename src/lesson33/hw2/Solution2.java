package lesson33.hw2;

import java.io.*;

public class Solution2 {
    public static void readFileByConsolePath() {
        System.out.println("Please, enter file path to read:");
        String path = readFromKeyboard();

        readFile(path);
    }

    public static String readFromKeyboard() {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);


        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            System.out.println("Error read from keyboard");
        } finally {
            try {
                inputStreamReader.close();
                bufferedReader.close();
            } catch (IOException e) {
                System.out.println("Error to close stream reader");
            }
        }
        return null;
    }

    public static void readFile(String path) {
        FileReader reader = null;
        try {
            reader = new FileReader(path);
        } catch (FileNotFoundException e) {
            System.err.println("File does not exist");
            return;
        }
        BufferedReader br = null;
        try {
            br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Can't read file by path " + path);
        } finally {
            try {
                if (br != null) br.close();
                if (reader != null) reader.close();
            } catch (IOException e) {
                System.err.println("Error to close reader strim");
            }
        }

    }

}
