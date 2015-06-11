/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tisseurdetoile.profileEngine.engine.simple;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author TisseurDeToile
 */
public class SpecificationList {
    List<AbstractHashSpecification>  specificationsList;

    public SpecificationList() {
        this.specificationsList = new ArrayList<AbstractHashSpecification>();
    }
    
    public AbstractHashSpecification addSpecification (AbstractHashSpecification spec) {
        
        
        if (!specificationsList.isEmpty()) {
            Iterator<AbstractHashSpecification> itSpec = specificationsList.iterator();
            
            while (itSpec.hasNext()) {
                AbstractHashSpecification readSpec = itSpec.next();
                
                if (readSpec.equals(spec)) {
                    return readSpec;
                }
            }
        }
        
        specificationsList.add(spec);
        
        return specificationsList.get (specificationsList.size() - 1);
    }

    public int size () {
        return specificationsList.size();
    }
    
    public List<AbstractHashSpecification>  getSpecifications () {
        return specificationsList;
    }
}
