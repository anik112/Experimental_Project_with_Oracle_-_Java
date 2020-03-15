/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import data.DBConnection;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import models.MarkerPlan;
import models.SizeManager;
import service.DataView;

/**
 *
 * @author Anik
 */
public class ChecksExistingSize {

    public Connection connection = DBConnection.connection();

    private final int XXS = 0;
    private final int XS = 1;
    private final int S = 2;
    private final int M = 3;
    private final int L = 4;
    private final int XL = 5;
    private final int XXL = 6;

    public List<SizeManager> getExistingSize(String style, String poNumber) {

        GetFromDatabase gfd = new DataView();
        MarkerPlan plans = gfd.getAllMarkerPlan(style, poNumber);

        List<SizeManager> sizeCheks = new ArrayList<>();

        if (plans.getXxs() > 0) {
            SizeManager manager = new SizeManager();
            manager.setIndex(XXS);
            manager.setValue(plans.getXxs());
            sizeCheks.add(manager);
        }
        if (plans.getXs() > 0) {
            SizeManager manager = new SizeManager();
            manager.setIndex(XS);
            manager.setValue(plans.getXs());
            sizeCheks.add(manager);
        }
        if (plans.getS() > 0) {
            SizeManager manager = new SizeManager();
            manager.setIndex(S);
            manager.setValue(plans.getS());
            sizeCheks.add(manager);
        }
        if (plans.getM() > 0) {
            SizeManager manager = new SizeManager();
            manager.setIndex(M);
            manager.setValue(plans.getM());
            sizeCheks.add(manager);
        }
        if (plans.getL() > 0) {
            SizeManager manager = new SizeManager();
            manager.setIndex(L);
            manager.setValue(plans.getL());
            sizeCheks.add(manager);
        }
        if (plans.getXl() > 0) {
            SizeManager manager = new SizeManager();
            manager.setIndex(XL);
            manager.setValue(plans.getXl());
            sizeCheks.add(manager);
        }
        if (plans.getXxl() > 0) {
            SizeManager manager = new SizeManager();
            manager.setIndex(XXL);
            manager.setValue(plans.getXxl());
            sizeCheks.add(manager);
        }
                
        return sizeCheks;
    }

}
