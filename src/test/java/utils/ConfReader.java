package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfReader {

    private static Properties props = new Properties();


    static {

        try {
            FileInputStream filo= new FileInputStream("keys.properties"); //ctr c ctr v path
            props.load(filo);
        } catch (IOException e) {
            System.out.println("File Not Found");
            e.printStackTrace();
        }

    }


    public static String getKey(String key) {

        return props.getProperty(key) ;
    }

}
