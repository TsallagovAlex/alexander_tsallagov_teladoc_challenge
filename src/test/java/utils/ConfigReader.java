package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    /**
     * This method is used to read property values from properties file
     * @param property is key name of the property
     * @param filePath is location of our config file
     * @return method will return a String value of the property
     */
    public static String readProperty(String property, String filePath){
        Properties prop = null;

        try {
            FileInputStream fileInput = new FileInputStream(filePath);
            prop = new Properties();
            prop.load(fileInput);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e1){
            e1.printStackTrace();
        }

        return prop.getProperty(property);
    }

}
