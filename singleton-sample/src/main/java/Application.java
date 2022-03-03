import java.util.Properties;

public class Application {

    public static void main(String[] args) {
        long start;
        long end;

        start = System.currentTimeMillis();
        Properties propertiesInstance1 = Configuration.getPropertiesInstance();
        end = System.currentTimeMillis();
        System.out.println(end-start);
        String username = propertiesInstance1.getProperty("username");
        System.out.println(username);

        start = System.currentTimeMillis();
        Properties propertiesInstance2 = Configuration.getPropertiesInstance();
        end = System.currentTimeMillis();
        System.out.println(end-start);
        String password = propertiesInstance2.getProperty("password");
        System.out.println(password); // here it takes 0 milliseconds cause not consuming time to create a new instance
    }
}
