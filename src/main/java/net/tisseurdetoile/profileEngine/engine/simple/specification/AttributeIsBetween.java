/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tisseurdetoile.profileEngine.engine.simple.specification;

import java.util.List;
import net.tisseurdetoile.profileEngine.data.ICandidate;
import net.tisseurdetoile.profileEngine.engine.simple.AbstractHashSpecification;

/**
 *
 * @author 11646n
 */
public class AttributeIsBetween extends AbstractHashSpecification {
    

    public AttributeIsBetween(String paramName, List<String> ParamValues, boolean nullIsEmpty) {
        this.paramName = paramName;
        this.paramValues = ParamValues;
        this.nullIsEmptyOrZero = nullIsEmpty;

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
