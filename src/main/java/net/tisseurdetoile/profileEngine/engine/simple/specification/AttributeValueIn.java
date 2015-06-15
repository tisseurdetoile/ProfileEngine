/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tisseurdetoile.profileEngine.engine.simple.specification;

import java.util.ArrayList;
import net.tisseurdetoile.profileEngine.data.ICandidate;
import net.tisseurdetoile.profileEngine.engine.simple.AbstractHashSpecification;

/**
 *
 * @author 11646n
 */
public class AttributeValueIn extends AbstractHashSpecification {

    
    
    
    public AttributeValueIn(String paramName, String ParamValue, boolean nullIsEmpty) {
        this.paramValues = new ArrayList<String>();
        
        this.paramName = paramName;
        this.paramValues.add(ParamValue);
        this.nullIsEmptyOrZero = nullIsEmpty;
    }

    public AttributeValueIn(String paramName, String ParamValue) {
        this(paramName, ParamValue, false);

    }

    @Override
    public boolean isSatisfiedBy(ICandidate candidate) {
        if (candidate != null) {
            if (this.nullIsEmptyOrZero && this.paramValue == null) {
                if (!candidate.containsKey(this.paramName) || (candidate.get(this.paramName) == null)) {
                    return true;
                }
            }

            if (candidate.containsKey(this.paramName) && this.paramValue != null && this.paramValue.equalsIgnoreCase(candidate.get(this.paramName))) {
                return true;
            }

        }
        return false;
    }
}
