package myapp.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    //this class is used for reading configuration.properties file
    private static Properties properties;

    //static block is called first every single time, is used for pre-requisites
    static {
        String path = "configuration.properties";
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //this method accepts KEY and returns VALUE: ConfigReader.getProperty(amazon_url); => https://www.amazon.com
    public static String getProperty(String key){
        String value = properties.getProperty(key);
        return value;
    }





}
