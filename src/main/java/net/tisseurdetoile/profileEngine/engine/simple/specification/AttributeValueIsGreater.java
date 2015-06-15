/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tisseurdetoile.profileEngine.engine.simple.specification;

import net.tisseurdetoile.profileEngine.data.ICandidate;
import net.tisseurdetoile.profileEngine.engine.simple.AbstractHashSpecification;

/**
 *
 * @author 11646n
 */
public class AttributeValueIsGreater extends AbstractHashSpecification {

    public AttributeValueIsGreater(String paramName, String ParamValue, boolean nullIsZero) {
        this.paramName = paramName;
        this.paramValue = ParamValue;
        this.nullIsEmptyOrZero = nullIsZero;

    }

    public AttributeValueIsGreater(String paramName, String ParamValue) {
        this(paramName, ParamValue, false);

    }

    @Override
    public boolean isSatisfiedBy(ICandidate candidate) {
        
        if (candidate != null) {
            int iparamvalue = Integer.valueOf(this.paramValue);
            int ivalue  = 0;
            
            if (candidate.containsKey(paramName)) {
                ivalue = Integer.valueOf(candidate.get(paramName));                
            } else if (!this.nullIsEmptyOrZero){
                return false;
            }
            
            return (ivalue > iparamvalue);
        }
        return false;
    }
}
