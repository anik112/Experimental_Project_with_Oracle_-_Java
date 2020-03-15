/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import core.GetFromDatabase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.MarkerPlan;

/**
 *
 * @author Anik
 */
public class DataView implements GetFromDatabase {

    @Override
    public List<String> getAllBuyerInformation() {

        List<String> buyerList = new ArrayList<>();

        String sql = "SELECT BUYER_NAME FROM TB_BUYER_INFO";
        try {
            PreparedStatement statement = connection.prepareCall(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                buyerList.add(rs.getString(1));
            }

        } catch (Exception e) {
            System.err.println("GetFromDatabase-> buyer: " + e.getMessage());
        }
        return buyerList;
    }

    @Override
    public List<String> getAllStyleInformation() {

        List<String> styleList = new ArrayList<>();

        String sql = "SELECT STYLE_NAME FROM TB_STYLE_INFO";
        try {
            PreparedStatement statement = connection.prepareCall(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                styleList.add(rs.getString(1));
            }

        } catch (Exception e) {
            System.err.println("GetFromDatabase-> style: " + e.getMessage());
        }
        return styleList;
    }

    @Override
    public List<String> getAllPoNumberAcoudingToStyle(String style) {

        List<String> listOfPoNumber = new ArrayList<>();

        String sql = "SELECT PO_NUMBER FROM TB_PURCHASE_ORDER WHERE STYLE_NAME='" + style + "'";

        try {
            PreparedStatement statement = connection.prepareCall(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                listOfPoNumber.add(rs.getString(1));
            }
        } catch (Exception e) {
            System.err.println("DataView: " + e.getMessage());
        }

        return listOfPoNumber;
    }

    @Override
    public List<String> getAllPartsName() {
        List<String> listOfPrtsName = new ArrayList<>();

        String sql = "SELECT PARTS_NAME FROM TB_PARTS_INFO";

        try {
            PreparedStatement statement = connection.prepareCall(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                listOfPrtsName.add(rs.getString(1));
            }
        } catch (Exception e) {
            System.err.println("DataView: " + e.getMessage());
        }

        return listOfPrtsName;
    }

    @Override
    public MarkerPlan getAllMarkerPlan(String style, String poNumber) {

        String sql = "SELECT * FROM TB_MARKER_PLAN WHERE STYLE_NAME='" + style + "' AND PO_NUMBER='" + poNumber + "'";
        MarkerPlan mp = new MarkerPlan();

        try {
            PreparedStatement statement = connection.prepareCall(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                mp.setStyleName(rs.getString(2));
                mp.setPoNumber(rs.getString(3));
                mp.setStdPlyHeight(rs.getInt(4));
                mp.setYy(rs.getInt(6));
                mp.setXxs(rs.getInt(7));
                mp.setXs(rs.getInt(8));
                mp.setS(rs.getInt(9));
                mp.setM(rs.getInt(10));
                mp.setL(rs.getInt(11));
                mp.setXl(rs.getInt(12));
                mp.setXxl(rs.getInt(13));
                mp.setTotal(rs.getInt(14));
            }
        } catch (Exception e) {
            System.err.println("DataView: -> MarkerPlans: " + e.getMessage());
        }

        return mp;
    }

    @Override
    public List<String> getExistsParts(String style) {
        String sql = "SELECT PARTS_NAME FROM TB_PARTS_PIVOT WHERE STYLE_NAME='" + style + "'";
        List<String> existsPartsDtls = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareCall(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                String s = rs.getString(1);
                existsPartsDtls.add(s);
            }
        } catch (Exception e) {
            System.err.println("DataView: -> existingParts: " + e.getMessage());
        }
        return existsPartsDtls;
    }

}
