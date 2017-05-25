/**
 * 
 */
package com.vangbacdaquy.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;

import com.vangbacdaquy.constant.Configuration;


/**
 * @author minhn
 *
 */
public class CustomServletContextListener implements ServletContextListener {
    private Properties prop = new Properties();
	final Logger logger = Logger.getLogger(CustomServletContextListener.class);
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		logger.info("ServletContextListener destroyed");
	}

	// Run this before web application is started
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("ServletContextListener started");
		initConfig();
		ServletContext ctx = arg0.getServletContext();
	}

	public void initConfig(){
		
		updateLog4jConfiguration("log4j.properties");
	    try {
	        loadConfigPropertyFile("config_local.properties");
	        
	        Configuration.IP_SERVER_MYSQL = prop.getProperty("ip_server_mysql").trim();
	        Configuration.PORT_SERVER_MYSQL = prop.getProperty("port_server_mysql").trim();
	        Configuration.DB_NAME_MYSQL = prop.getProperty("db_name_mysql").trim();
	        Configuration.USERNAME_MYSQL = prop.getProperty("username_mysql").trim();
	        Configuration.PASSWORD_MYSQL = prop.getProperty("password_mysql").trim();
	        
	        Configuration.IP_SERVER_MONGO = prop.getProperty("ip_server_mongo").trim();
	        Configuration.PORT_SERVER_MONGO = prop.getProperty("port_server_mongo").trim();
	        
	        Configuration.DEPLOY_FOLDER = prop.getProperty("deploy_folder").trim();
	        
        } catch (Exception e) {
            System.out.println("Sorry, cann't load server info");
        }
	    
	    
	    
	}
	
	
	private void loadConfigPropertyFile(String fileName) {

        InputStream input = null;
        try {
            input = CustomServletContextListener.class.getClassLoader().getResourceAsStream(fileName);
            if(input==null){
                    System.out.println("Sorry, unable to find " + fileName);
                return;
            }
            prop.clear();
            prop.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
	
	private void updateLog4jConfiguration(String logFile) { 
	  
		LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
		loggerContext.getLogger("org.mongodb.driver").setLevel(Level.INFO);
		loggerContext.getLogger("org.apache.struts2").setLevel(Level.INFO);
		loggerContext.getLogger("edu.emory.clir").setLevel(Level.INFO);
		loggerContext.getLogger("c.o.x").setLevel(Level.INFO);
		loggerContext.getLogger("com.opensymphony.xwork2").setLevel(Level.INFO);
		loggerContext.getLogger("freemarker.beans").setLevel(Level.INFO);
		loggerContext.getLogger("freemarker.cache").setLevel(Level.INFO);
		loggerContext.getLogger("twitter4j").setLevel(Level.INFO);
	 }
}
