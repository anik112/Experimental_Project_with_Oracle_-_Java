/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import data.DBConnection;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Anik
 */
public interface GetFromDatabase {
    
    public Connection connection=DBConnection.connection();
    
    public List<String> getAllBuyerInformation();
    
    public List<String> getAllStyleInformation();
    
    public List<String> getAllPoNumberAcoudingToStyle(String style);
    
    public List<String> getAllPartsName();
    
}
