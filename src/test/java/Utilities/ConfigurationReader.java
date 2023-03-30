package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    //1- Create the object of Properties class
    // We need properties class to use methods coming from class like "load() , getProperty("key")"
    //it is static because we using it in static method and static block
    // it is private because I will be using only this class
    private static Properties properties = new Properties();
    //We want open the properties file and load to properties object ONLY ONCE before reading
    //having static block because static runs first

    static {


        try {
            //2- Create the object of FileInputStream
            //We need this object to open file as a stream in Java memory
            FileInputStream file = new FileInputStream("configuration.properties");

            //3- Load the properties object using FileInputStream objet
            //Load "properties" object with the "file" we opened using FileInputStream
            properties.load(file);

            //close the file after loading
            //if we do not close the file, it will take space from computer memory like Scanner
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method is used to read value from a configuration.properties file
     * @param /key --> key name in configuration.properties file
     * @return --> value for the key. returns null if key is not found
     * driver.get(ConfigurationReader.getProperty("env")
     */

    public static String getProperty(String key){

        return properties.getProperty(key);
    }

}
