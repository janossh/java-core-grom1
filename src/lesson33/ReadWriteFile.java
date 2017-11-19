package lesson33;

import java.io.*;

public class ReadWriteFile {

    public static void readFile(String path) {
        FileReader reader = null;
        try {
            reader = new FileReader(path);
        } catch (FileNotFoundException e) {
            System.err.println("File does not exist");
        }
        BufferedReader br = new BufferedReader(reader);
        try {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Reading from file " + path + " failed");
        }finally {
            try {
                br.close();
                reader.close();
            }catch (IOException e){
                System.err.println("Error to close reader strim");
            }
        }

    }

    public static void writeFile(String path, String content) {
        FileWriter writer = null;
        BufferedWriter bufferedWriter = null;
        try {
            writer = new FileWriter(path,true);
            bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.append("\n");
            bufferedWriter.append(content);
        } catch (IOException e) {
            System.err.println("Can't write to file");
        }finally {
            try {
                bufferedWriter.close();
                writer.close();
            }catch (IOException e){
                System.err.println("Error to close writer strim");
            }
        }
    }
}
