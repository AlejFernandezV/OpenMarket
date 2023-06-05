package com.unicauca.edu.co.openmarket.client.commands;

import com.unicauca.edu.co.openmarket.client.access.CategoryAccessImplSockets;
import com.unicauca.edu.co.openmarket.commons.domain.Category;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OMAddCategoryCommand extends OMCommand {

    private Category cC;
    private CategoryAccessImplSockets cA;
    boolean result=false;
    public OMAddCategoryCommand(Category cC, CategoryAccessImplSockets cA){
        this.cC = cC;
        this.cA = cA;
    }
    
    
    @Override
    public void make() {
        try {
            result = cA.saveC(cC);
        } catch (Exception ex) {
            Logger.getLogger(OMAddCategoryCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void unmake() {
        List<Category> categories = null;
        try {
            categories = cA.findAllC();
        } catch (Exception ex) {
            Logger.getLogger(OMAddCategoryCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Category eachC : categories) {
            if(eachC.getName().equals(cC.getName())){
                try {
                    result = cA.deleteC(eachC.getCategoryId());
                } catch (Exception ex) {
                    Logger.getLogger(OMAddCategoryCommand.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public boolean result(){
        return result;
    }
    
}
