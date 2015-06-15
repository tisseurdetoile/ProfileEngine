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
public class AttributeValueIs extends AbstractHashSpecification {

    public AttributeValueIs(String paramName, String ParamValue, boolean nullIsEmpty) {
        this.paramName = paramName;
        this.paramValue = ParamValue;
        this.nullIsEmpty = nullIsEmpty;

    }

    public AttributeValueIs(String paramName, String ParamValue) {
        this(paramName, ParamValue, false);

    }

    @Override
    public boolean isSatisfiedBy(ICandidate candidate) {
        if (candidate != null) {
            if (this.nullIsEmpty && this.paramValue == null) {
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
