package lesson33.hw1;

import java.io.*;

public class Solution {
    public static void writeToFileFromConsole(String path) {
        FileReader reader = null;
        try {
            reader = new FileReader(path);
        } catch (IOException e) {
            System.out.println("File with path " + path + " not found");
            return;
        } finally {
            try {
                if (reader != null) reader.close();
            } catch (IOException e) {
                System.out.println("Can't close file");
            }
        }


        System.out.println("Enter file content to write in the file:");
        String stringToFile = readFromKeyboard();
        writeFile(path, stringToFile);
    }

    public static String readFromKeyboard() {
        StringBuilder stringBuilder = new StringBuilder();

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String flEnd = "wr";
        StringBuilder newLine;
        String str = "";

        try {
            while (!flEnd.equals(str = bufferedReader.readLine())) {
                newLine = new StringBuilder(str);
                stringBuilder.append(newLine + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("Error read from keyboard");
        }

        try {
            inputStreamReader.close();
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Error to close stream reader");
        }


        return stringBuilder.toString();
    }

    public static void writeFile(String path, String content) {
        FileWriter writer = null;
        BufferedWriter bufferedWriter = null;
        try {
            writer = new FileWriter(path, true);
            bufferedWriter = new BufferedWriter(writer);
            //bufferedWriter.append(System.lineSeparator());
            bufferedWriter.append(content);
        } catch (IOException e) {
            System.err.println("Can't write to file " + path);
        } finally {
            try {
                bufferedWriter.close();
                writer.close();
            } catch (IOException e) {
                System.err.println("Error to close writer strim");
            }
        }
    }
}
