/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tisseurdetoile.profileEngine.engine.simple2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author TisseurDeToile
 */
public class SpecificationList {

     private static final String className = SpecificationList.class.getName();
     private static final Logger LOG = Logger.getLogger(className);
     
    
    List<AbstractHashSpecification> specificationsList;

    public SpecificationList() {
        this.specificationsList = new ArrayList<AbstractHashSpecification>();
    }

    protected AbstractHashSpecification getSameSpecification(final AbstractHashSpecification spec) {
        final String methodName = "getSameSpecification";
        LOG.entering(className, methodName);
        
        if (!specificationsList.isEmpty()) {
            Iterator<AbstractHashSpecification> itSpec = specificationsList.iterator();

            while (itSpec.hasNext()) {
                AbstractHashSpecification readSpec = itSpec.next();

                if (readSpec.equals(spec)) {
                    LOG.exiting(methodName, methodName, readSpec);
                    return readSpec;
                }
            }
        }
        
        LOG.exiting(methodName, methodName, null);
        return null;
    }

    public AbstractHashSpecification addSpecification(AbstractHashSpecification spec) {

        AbstractHashSpecification readSpec = getSameSpecification(spec);
        
        if (readSpec != null) {
            return readSpec;
        } else {
            specificationsList.add(spec);
        }

        return specificationsList.get(specificationsList.size() - 1);
    }

    public int size() {
        return specificationsList.size();
    }

    public List<AbstractHashSpecification> getSpecifications() {
        return specificationsList;
    }
}
