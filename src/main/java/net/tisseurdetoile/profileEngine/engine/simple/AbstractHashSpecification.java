/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tisseurdetoile.profileEngine.engine.simple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import net.tisseurdetoile.profileEngine.data.Candidate;
import net.tisseurdetoile.profileEngine.specifications.*;

/**
 * @author 11646n
 */
public abstract class AbstractHashSpecification extends AbstractSpecification<Candidate> {
    
    protected DataType type;
    protected UUID uuid;
    
    protected List<AbstractHashSpecification> gtSpecifications;
    protected List<AbstractHashSpecification> ltSpecifications;
    
    protected String paramName;
    protected String paramValue;
    protected List<String> paramValues;
    protected boolean nullIsEmpty;

    public AbstractHashSpecification() {
        this.uuid = UUID.randomUUID();
        this.gtSpecifications = new ArrayList<AbstractHashSpecification>();
        this.ltSpecifications = new ArrayList<AbstractHashSpecification>();
    }
    
    public String getUUID () {
        return this.uuid.toString();
    }
    
    
    protected boolean findResultInChild () {
         if (!this.ltSpecifications.isEmpty()) {
             
         }
         
         return false;
    }
    
    public boolean equals (AbstractHashSpecification spec) {
        
        if (!this.type.equals(spec.type)) {
            return false;
        }
        
        if (!this.paramName.equals(spec.paramName)) {
            return false;
        }
        
        if (this.nullIsEmpty != spec.nullIsEmpty) {
            return false;
        }
        
        if (DataType.String == this.type) {
            return (this.paramValue.equals(spec.paramValue));
        }
        
        if (DataType.List == this.type) {
            return (this.paramValues.equals(spec.paramValues));
        }
        
        
        return true;
    }

}
