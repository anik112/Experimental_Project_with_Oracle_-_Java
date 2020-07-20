/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportgenerator.dbConnection;

/**
 *
 * @author Anik
 */
public class ConfigKeyList {
    
    public final String KEY_ORACLE_BASE_URL="ORAURL";
    public final String KEY_SERVER_NAME = "SER";
    public final String KEY_PORT_NUMBER="PORT";
    public final String KEY_USER_NAME = "USR";
    public final String KEY_USER_PASSWORD = "PWS";
    public final String KEY_DATABSE_NAME = "SDB";

    public String getKEY_SERVER_NAME() {
        return KEY_SERVER_NAME;
    }

    public String getKEY_PORT_NUMBER() {
        return KEY_PORT_NUMBER;
    }

    public String getKEY_USER_NAME() {
        return KEY_USER_NAME;
    }

    public String getKEY_USER_PASSWORD() {
        return KEY_USER_PASSWORD;
    }

    public String getKEY_DATABSE_NAME() {
        return KEY_DATABSE_NAME;
    }

    public String getKEY_ORACLE_BASE_URL() {
        return KEY_ORACLE_BASE_URL;
    }
    
    
}
