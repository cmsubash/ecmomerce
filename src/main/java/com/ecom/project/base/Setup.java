package com.ecom.project.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Setup {
public static WebDriver driver;
public static FileInputStream fis;
public static Properties prop;
public static File file;
public static String browser=" ";
public static String url=" ";

public Setup()
{
	file=new File("./Config/config.properties");
	try {
		fis=new FileInputStream(file);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	prop=new Properties();
	try {
		prop.load(fis);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	browser=prop.getProperty("browser");
	url=prop.getProperty("url");
}
public static void initization()

{
	if(browser.equals("chrome"))
	{
		driver=new ChromeDriver();
	}
	else if (browser.equals("firefox"))
	{
		driver=new FirefoxDriver();
		}
	else 
	{
		System.out.println("Browser Not Found");
	}
}
}
