package mvvmtype2examples;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DataConnect {
    private static SessionFactory sesfact;
    private DataConnect() {
        sesfact = new Configuration().configure("Hiber.cfg.xml").addAnnotatedClass(Bookpojo.class).buildSessionFactory();
    }
    
    public static SessionFactory getConnection() {
        if(sesfact==null) {
            DataConnect dataconnect = new DataConnect();
        }
        return sesfact;
    }
    public static void main(String[] args) {
        getConnection();
        System.out.println("Tables created");
    }
    
}