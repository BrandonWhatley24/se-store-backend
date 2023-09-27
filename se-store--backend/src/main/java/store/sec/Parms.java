package store.sec;

public class Parms {

    public static final String dbuser = "softeng";
    public static final String dbpass = "password";
    public static final String dbname = "postgres";
    public static final String dbschema = "storedb";

    // We need to change the "localhost" part based on VM IP
    // Until we can figure out a separate server system to handle that
//  public static final String dburl = "jdbc:postgresql://localhost:5432/postgres";
    public static final String dburl = "jdbc:postgresql://192.168.0.37:5432/postgres";
}
