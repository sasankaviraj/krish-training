import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {

    public static volatile Properties properties;
    private static final String FILE_NAME = "/application.properties";

    private Configuration(){
        if (null == properties){
            throw new RuntimeException("Use getPropertiesInstance method to get a new instance");
        }
    }

    public static Properties getPropertiesInstance(){
        if (null == properties){
            synchronized (Configuration.class){
                if(null == properties){
                    try {
                        properties = new Properties();
                        InputStream inputStream = Configuration.class.getResourceAsStream(FILE_NAME);
                        if(null != inputStream){
                            properties.load(inputStream);
                            inputStream.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return properties;
    }
}
