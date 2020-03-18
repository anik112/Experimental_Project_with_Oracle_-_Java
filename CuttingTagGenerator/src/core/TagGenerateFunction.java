/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.ArrayList;
import java.util.List;
import models.BundlesPlan;
import models.SizeManager;
import service.DataStore;
import service.DataView;

/**
 *
 * @author Anik
 */
public class TagGenerateFunction implements cuttingtaggenerator.TagGenerate {

    private String sizeList[] = {"XXS", "XS", "S", "M", "L", "XL", "XXL"};
    private int lngth = 0;

    @Override
    public void createTag(int rollQty[], String rolls[], String style, String poNumber) {

        GetFromDatabase gfd = new DataView();
        List<String> existsPartsDtls = gfd.getExistsParts(style);
        lngth = rollQty.length;

        List<SizeManager> sizeCheks = new ArrayList<>();
        sizeCheks = new ChecksExistingSize().getExistingSize(style, poNumber);

        int bundel = 1;
        int serialCount = 1;

        // main loop 
        for (int i = 0; i < existsPartsDtls.size(); i++) {
            for (int j = 0; j < lngth; j++) {
                for (int k = 0; k < sizeCheks.size(); k++) {
                    int itemSerialTo=serialCount;
                    int itemSerialFrom=((serialCount + rollQty[j]) - 1);
                    int itemQtyTemp=(rollQty[j] * (sizeCheks.get(k).getValue()));
                    System.out.println("=========================================");
                    System.out.println("Bundel No: " + bundel + " --- Po: " + poNumber);
                    System.out.println("Style: " + style + " ---- Parts: " + existsPartsDtls.get(i));
                    System.out.println("Roll No: " + rolls[j] + " ----- Size: " + sizeList[sizeCheks.get(k).getIndex()]);
                    System.out.println("Qty: " + itemQtyTemp);
                    System.out.println("Serial No: " + itemSerialTo + " to " + itemSerialFrom);
                    System.out.println("=========================================");
                    
                    
                    
                    BundlesPlan plan=new BundlesPlan();
                    StoreInDatabase inDatabase=new DataStore();
                    inDatabase.storeBundlesPlan(plan);
                    serialCount += rollQty[j];
                    bundel++;
                }
            }
        }

    }

}
