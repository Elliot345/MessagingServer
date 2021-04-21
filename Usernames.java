import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Usernames {
  final static String propertiesFile = "Users.properties";

  public static Properties getUsernames() throws Exception {
    // initiating properties 
    Properties props = new Properties();

    // populating properties
    props.load(new FileInputStream(propertiesFile));

    return props;
  }
  public static void addUsername(String username, String password) throws Exception {
    // importing properties
    Properties props = getUsernames();

    // setting up FileOutputStream
    FileOutputStream out = new FileOutputStream(propertiesFile);

    // adding user
    props.setProperty(username, Hash.hash(password));

    props.store(out, "--No Comment--");
  }
  public static boolean isUsernameAvailable(String username) throws Exception {
    Properties props = getUsernames();
    
    if (props.getProperty(username) == null) {
      return true;
    } else {
      return false;
    }
  }
}