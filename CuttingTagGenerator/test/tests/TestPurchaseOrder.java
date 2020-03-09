/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import core.StoreInDatabase;
import models.MarkerPlan;
import models.PurchaseOrder;
import service.DataStore;

/**
 *
 * @author VSI-ANIK
 */
public class TestPurchaseOrder {
    
    public void testPurchase(){
        
        PurchaseOrder order=new PurchaseOrder();
        
        order.setBuyerName("abc");
        order.setStyleName("assf");
        order.setPoNumber("OP-00215");
        order.setCargoReciveDate("02/10/2020");
        order.setFirstCuttingDate("03/12/2019");
        order.setIssueDate("01/02/2020");
        order.setFactoryName("Vistasoft It bangladesh Ltd.");
        order.setFabricAmount(12);
        
        StoreInDatabase dbDatabase=new DataStore();
        dbDatabase.storePurchasOrder(order);
        
    }
    
    
    public void testMarker(){
        MarkerPlan plan=new MarkerPlan();
        
        plan.setStyleName("");
    }
    
}
