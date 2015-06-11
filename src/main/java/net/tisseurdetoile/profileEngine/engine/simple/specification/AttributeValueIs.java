/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tisseurdetoile.profileEngine.engine.simple.specification;

import java.util.HashMap;
import net.tisseurdetoile.profileEngine.data.Candidate;
import net.tisseurdetoile.profileEngine.engine.simple.AbstractHashSpecification;
import net.tisseurdetoile.profileEngine.engine.simple.DataType;
import net.tisseurdetoile.profileEngine.engine.simple.SpecificationScope;

/**
 *
 * @author 11646n
 */
public class AttributeValueIs extends AbstractHashSpecification {

    public static final SpecificationScope SCOPE = new SpecificationScope(DataType.String, "La valeur est :");

    public AttributeValueIs(String paramName, String ParamValue, boolean nullIsEmpty) {
        this.type = DataType.String;

        this.paramName = paramName;
        this.paramValue = ParamValue;
        this.nullIsEmpty = nullIsEmpty;

    }

    public AttributeValueIs(String paramName, String ParamValue) {
        this(paramName, ParamValue, false);

    }

    @Override
    public boolean isSatisfiedBy(Candidate candidate) {
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
