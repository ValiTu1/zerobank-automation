package com.zerobank.utilities;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class ConfigurationReader {

    private ConfigurationReader(){}

    private static Properties properties = new Properties();

    static{

        try{

            //adding the path to configuration.properties file
            String path ="configuration.properties";

            //adding the file into java memory
            FileInputStream input = new FileInputStream(path);
            properties.load(input);

            input.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String get(String keyName){
        return properties.getProperty(keyName);
    }

}
