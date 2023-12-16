package com.hexaware.util;
import java.io.IOException;
import java.util.Properties;
import java.io.InputStream;

public class PropertyUtil {
     
	 public static String getPropertyString()
	 {
		 Properties properties = new Properties();
		 String propertyFilename="database.properties";
		 
		 try(InputStream input = PropertyUtil.class.getClassLoader().getResourceAsStream(propertyFilename))
		 {
			 if(input == null)
			 {
				 System.out.println("Sorry,unable to find " + propertyFilename);
				 return null;
			 }
			 properties.load(input);
			 String hostname = properties.getProperty("hostname");
			 String dbname = properties.getProperty("dbname");
			 String username = properties.getProperty("username");
			 String password = properties.getProperty("password");
			 String port = properties.getProperty("port");
			 
			 return String.format("jdbc:mysql://%s:%s/%s?user=%s&password=%s",hostname,port,dbname,username,password);
		 }
		 catch(IOException ex)
		 {
			 ex.printStackTrace();
			 return null;
			 
		 }
	 }

}
