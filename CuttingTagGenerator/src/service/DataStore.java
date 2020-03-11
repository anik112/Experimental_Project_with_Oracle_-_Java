/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.PreparedStatement;
import models.BundlesPlan;
import models.MarkerPlan;
import models.PurchaseOrder;

/**
 *
 * @author VSI-ANIK
 */
public class DataStore implements core.StoreInDatabase {

    @Override
    public void storeBuyerInformation(String buyerName) {

        String sql = "INSERT INTO TB_BUYER_INFO (BUYER_NAME) VALUES ('" + buyerName + "')";

        try {

            PreparedStatement statement = dataConn.prepareCall(sql);
            statement.executeUpdate();
            System.out.println("DataStore: Data  update");

        } catch (Exception e) {
            System.err.println("DataStore: " + e.getMessage());
        }
    }

    @Override
    public void storeStyleInformation(String styleName) {

        String sql = "INSERT INTO TB_STYLE_INFO (STYLE_NAME) VALUES ('" + styleName + "')";

        try {

            PreparedStatement statement = dataConn.prepareCall(sql);
            statement.executeUpdate();
            System.out.println("DataStore: Data  update");

        } catch (Exception e) {
            System.err.println("DataStore: " + e.getMessage());
        }
    }

    @Override
    public void storePartsInfo(String partsName) {
        String sql = "INSERT INTO TB_PARTS_INFO (PARTS_NAME) VALUES ('" + partsName + "')";

        try {

            PreparedStatement statement = dataConn.prepareCall(sql);
            statement.executeUpdate();
            System.out.println("DataStore: Data  update");

        } catch (Exception e) {
            System.err.println("DataStore: " + e.getMessage());
        }
    }

    @Override
    public void storePurchasOrder(PurchaseOrder order) {

        String sql = "INSERT INTO TB_PURCHASE_ORDER ("
                + "BUYER_NAME,"
                + "STYLE_NAME,"
                + "PO_NUMBER,"
                + "FACTORY_NAME,"
                + "FIRST_CUTTING_DATE,"
                + "FABRIC_AMOUNT,"
                + "ISSUE_DATE,"
                + "CARGO_RECIVE_DATE) VALUES ("
                + "'" + order.getBuyerName() + "',"
                + "'" + order.getStyleName() + "',"
                + "'" + order.getPoNumber() + "',"
                + "'" + order.getFactoryName() + "',"
                + "TO_DATE('" + order.getFirstCuttingDate() + " 00:00:00', 'MM/DD/YYYY HH24:MI:SS'),"
                + order.getFabricAmount() + ","
                + "TO_DATE('" + order.getIssueDate() + " 00:00:00', 'MM/DD/YYYY HH24:MI:SS'),"
                + "TO_DATE('" + order.getCargoReciveDate() + " 00:00:00', 'MM/DD/YYYY HH24:MI:SS')"
                + ")";

        try {

            PreparedStatement statement = dataConn.prepareCall(sql);
            statement.executeUpdate();
            System.out.println("DataStore: Data  update Purchas Order");

        } catch (Exception e) {
            System.err.println("DataStore: " + e.getMessage());
        }
    }

    @Override
    public void storeMarkerPlan(MarkerPlan plan) {

        String sql = "INSERT INTO TB_MARKER_PLAN ("
                + "STYLE_NAME,"
                + "PO_NUMBER,"
                + "STD_PLYHEIGHT,"
                + "TB_LENGTH,"
                + "YY,"
                + "XXS,"
                + "XS,"
                + "S,"
                + "M,"
                + "L,"
                + "XL,"
                + "XXL,"
                + "TOTAL) VALUES ("
                + "'" + plan.getStyleName() + "',"
                + "'" + plan.getPoNumber() + "',"
                + plan.getStdPlyHeight() + ","
                + plan.getTbLength() + ","
                + plan.getYy() + ","
                + plan.getXxs() + ","
                + plan.getXs() + ","
                + plan.getS() + ","
                + plan.getM() + ","
                + plan.getL() + ","
                + plan.getXl() + ","
                + plan.getXxl() + ","
                + plan.getTotal() + ")";

        try {

            PreparedStatement statement = dataConn.prepareCall(sql);
            statement.executeUpdate();
            System.out.println("DataStore: Data  update marker plan");

        } catch (Exception e) {
            System.err.println("DataStore: " + e.getMessage());
            e.printStackTrace();
        }

    }

    @Override
    public void storeBundlesPlan(BundlesPlan plan) {
        String sql = "INSERT INTO TB_BUNDLES_PLAN ("
                + "STYLE_NAME,"
                + "PO_NUMBER,"
                + "CUTTING_NUMBER,"
                + "ROLL_NO,"
                + "LAYS,"
                + "B_SIZE,"
                + "DBL,"
                + "PARTS,"
                + "SERIAL_TO,"
                + "SERIAL_FROM,"
                + "QTY) VALUES ("
                + "'" + plan.getStyleName() + "',"
                + "'" + plan.getPoNumber() + "',"
                + plan.getCuttingNumber() + ","
                + "'" + plan.getRollNumber() + "',"
                + plan.getLays() + ","
                + plan.getSize() + ","
                + plan.getDbl() + ","
                + "'" + plan.getPartsName() + "',"
                + plan.getSerialTo() + ","
                + plan.getSerialFrom() + ","
                + plan.getQty()
                + ")";

        try {
            PreparedStatement statement = dataConn.prepareCall(sql);
            statement.executeUpdate();
            System.out.println("DataStore: Data  update bundles plan");
        } catch (Exception e) {
            System.err.println("Data Store: " + e.getMessage());
        }

    }

    @Override
    public void storePartsPivot(String styleName, String partsName) {
        String sql = "INSERT INTO TB_PARTS_PIVOT (STYLE_NAME,PARTS_NAME) VALUES ('" + styleName + "','"+partsName+"')";
        
        try{
            PreparedStatement statement = dataConn.prepareCall(sql);
            statement.executeUpdate();
            System.out.println("DataStore: Data  update povot");
        }catch(Exception e){
            System.err.println("DataStore: "+e.getMessage());
        }
    }

}
