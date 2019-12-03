package connection;


import java.sql.Connection;

/**
 *
 * @author Rajail Islam
 */
public class Test {
 
    public static void main(String[] args) {
        Connection conn = DbConnection.getConnection();
    }
}
