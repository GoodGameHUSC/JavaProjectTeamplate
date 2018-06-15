package helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * This isn't recommend in you test keep it like a reference resource when you
 * miss how to code
 * 
 * @author HunG
 *
 */
public class Filer {

    /**
     * path in java like : C:\\Users\\HunG\\Pictures\\1189616.png
     * 
     * @param pathToFile
     * @return
     */
    public static boolean isFileExist(String pathToFile) {
        File file = new File(pathToFile);
        if (file.exists() && !file.isDirectory()) {
            return true;
        }
        return false;
    }

    /**
     * 
     * @param pathToFile
     * @return
     * @throws IOException
     */
    public static ArrayList<String> readFileToArrayList(String pathToFile) throws IOException {
        FileReader f = null;
        BufferedReader r = null;
        ArrayList<String> list = new ArrayList<String>();
        f = new FileReader(pathToFile);
        r = new BufferedReader(f);

        while (true) {
            String line = r.readLine();
            if (line == null || line == "")
                break;
            list.add(line);
        }
        r.close();
        return list;
    }

    /**
     * 
     * @param pathToFile
     * @param content
     * @param APPEND
     * @return
     * @throws IOException
     */
    public static boolean writeArrayListToFile(String pathToFile, ArrayList<String> content, boolean APPEND)
            throws IOException {
        FileWriter w = null;
        PrintWriter p = null;

        if (APPEND)
            w = new FileWriter(pathToFile, true);
        else
            w = new FileWriter(pathToFile);
        p = new PrintWriter(w);

        for (String string : content) {
            p.println(string);
        }
        w.close();
        return false;
    }

    /**
     * Normally, we use try-catch instead of throws
     * 
     * @param pathToFile
     * @return
     */
    public static ArrayList<String> readFile(String pathToFile) {
        FileReader f = null;
        BufferedReader r = null;
        ArrayList<String> list = new ArrayList<String>();
        try {
            f = new FileReader(pathToFile);
            r = new BufferedReader(f);
            while (true) {
                String line = r.readLine();
                if (line == null || line == "")
                    break;
                list.add(line);
            }
            r.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found" + pathToFile);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Read File Error " + pathToFile);
            e.printStackTrace();
        }
        return list;
    }

    /**
     * Normally, we use try-catch instead of throws
     * 
     * @param pathToFile
     * @param content
     * @param APPEND
     * @return
     */
    public static boolean writeFile(String pathToFile, ArrayList<String> content, boolean APPEND) {
        FileWriter w = null;
        PrintWriter p = null;
        try {
            if (APPEND)
                w = new FileWriter(pathToFile, true);
            else
                w = new FileWriter(pathToFile);

            p = new PrintWriter(w);

            for (String string : content) {
                p.println(string);
            }
            w.close();
            return true;
        } catch (Exception e) {
            System.out.println("Write File Error :" + pathToFile);
        }

        return false;
    }
}
