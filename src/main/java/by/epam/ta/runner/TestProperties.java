package by.epam.ta.runner;

import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestProperties {
	
	public static final String PROPERTY_FILE_NAME = "test_properties.properties";

    private final Logger logger = Logger.getLogger(TestProperties.class);

    private static ThreadLocal<TestProperties> instance = new ThreadLocal<TestProperties>();

    private TestProperties() {
        setPropValues();
    }

    public static synchronized TestProperties getInstance() {
        if (null == instance.get())
            instance.set(new TestProperties());
        return instance.get();
    }

    private String baseUrl;

    private String browserType;

    private String userName;

    private String userPassword;

    private Integer defaultTimeout;

    public String getBaseUrl() {
        return this.baseUrl;
    }


    public String getBrowserType() {
        return this.browserType;
    }

    public String getUserName(){
        return this.userName;
    }

    public String getUserPassword(){
        return this.userPassword;
    }

    public Integer getDefaultTimeout() {
        return this.defaultTimeout;
    }

    public void setPropValues() {
        InputStream inputStream = null;
        try {
           
            Properties prop = new Properties();
            inputStream = getClass().getClassLoader().getResourceAsStream(PROPERTY_FILE_NAME);
            if (inputStream == null)
                throw new FileNotFoundException("property file '" + PROPERTY_FILE_NAME + "' not found in the classpath");

            prop.load(inputStream);

            baseUrl = prop.getProperty("environment.variables.base_url");
            browserType = prop.getProperty("environment.variables.browser");
            userName = prop.getProperty("test.variables.user_name");
            userPassword = prop.getProperty("test.variables.user_password");
            defaultTimeout = Integer.parseInt(prop.getProperty("test.variables.default.timeout"));
        } catch (Exception ex) {
            logger.error("Exception while initializing test properties. Exception: " + ex);
        } finally {
            try {
                if (null != inputStream)
                    inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

