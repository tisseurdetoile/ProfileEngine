/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tisseurdetoile.profileEngine.engine.simple;

import java.util.Iterator;

/**
 *
 * @author TisseurDeToile
 */
public class SpecificationTreeBuilder {
    SpecificationList specList = new SpecificationList();

    public SpecificationTreeBuilder(SpecificationList specList) {
        this.specList = specList;
    }
    
    
    
    public void parse () {
        
        Iterator<AbstractHashSpecification> itSpecification = this.specList.getSpecifications().iterator();
        
        while (itSpecification.hasNext()) {
            AbstractHashSpecification readSpec = itSpecification.next();
            
            
        }
        
    }
    
}
