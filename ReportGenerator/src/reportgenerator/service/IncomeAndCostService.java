/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportgenerator.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import reportgenerator.dao.EntryIncomeAndCostDao;
import reportgenerator.dbConnection.DBConnection;

/**
 *
 * @author Anik
 */
public class IncomeAndCostService {

    public boolean saveData(EntryIncomeAndCostDao costDao) {

        Connection connection = DBConnection.getConnection();

        try {
            PreparedStatement statement = connection.prepareCall("INSERT INTO TB_INCOME_AND_COST "
                    + "(ENTRY_DATE,DETLS,COM_NAME,INCOME,COST,TOTAL_AMOUNT) VALUES (?,?,?,?,?,?)");
            statement.setString(1, costDao.getDate());
            statement.setString(2, costDao.getDtls());
            statement.setString(3, costDao.getCompanyName());
            statement.setFloat(4, costDao.getIncome());
            statement.setFloat(5, costDao.getCost());
            statement.setFloat(6, costDao.getTotalAmount());

            statement.executeUpdate();
            connection.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    ":: ERROR-INCOME AND COST [SAVE DATA] :: ", JOptionPane.INFORMATION_MESSAGE);
        }
        return true;
    }

    public List<EntryIncomeAndCostDao> getData() {

        Connection connection = DBConnection.getConnection();
        List<EntryIncomeAndCostDao> list = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM TB_INCOME_AND_COST");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                EntryIncomeAndCostDao costDao = new EntryIncomeAndCostDao();

                costDao.setId(rs.getInt(1));
                costDao.setDate(rs.getString(2));
                costDao.setDtls(rs.getString(3));
                costDao.setCompanyName(rs.getString(4));
                costDao.setIncome(rs.getFloat(5));
                costDao.setCost(rs.getFloat(6));
                costDao.setTotalAmount(rs.getFloat(7));

                list.add(costDao);
            }
            //System.out.println("=> "+i);
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    ":: ERROR- SERVICE SUBMITE BILL [SELECT DATA] :: ", JOptionPane.INFORMATION_MESSAGE);
        }

        return list;
    }

}
