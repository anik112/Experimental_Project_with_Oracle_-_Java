/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import data.DBConnection;
import java.sql.Connection;
import models.BundlesPlan;
import models.MarkerPlan;
import models.Pivot;
import models.PurchaseOrder;

/**
 *
 * @author VSI-ANIK
 */
public interface StoreInDatabase {
    
    public Connection dataConn=DBConnection.connection();
    
    public void storeBuyerInformation(String buyerName);
    
    public void storeStyleInformation(String styleName);
    
    public void storePartsInfo(String partsName);
    
    public void storePurchasOrder(PurchaseOrder order);
    
    public void storePartsPivot(Pivot pivot);
    
    public void storeMarkerPlan(MarkerPlan plan);
    
    public void storeBundlesPlan(BundlesPlan plan);
    
    public void storePartsInformation(String partsName);
    
    public void storeWorkingPartsDtls(String styleName, String partsName);
    
}
