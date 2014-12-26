/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tisseurdetoile.profileEngine.specifications.hashmap;

import java.util.HashMap;
import net.tisseurdetoile.profileEngine.specifications.AbstractSpecification;
import net.tisseurdetoile.profileEngine.specifications.DataType;
import net.tisseurdetoile.profileEngine.specifications.SpecificationScope;

/**
 *
 * @author 11646n
 */
public class AttributeValueIn extends AbstractSpecification<HashMap<String, String>> {
    
    public static final SpecificationScope SCOPE = new SpecificationScope(DataType.String, "La valeur est :");

    private String paramName;
    private String paramValue;
    private boolean nullIsEmpty;

    public AttributeValueIn(String paramName, String ParamValue, boolean nullIsEmpty) {
        this.paramName = paramName;
        this.paramValue = ParamValue;
        this.nullIsEmpty = nullIsEmpty;
    }

    public AttributeValueIn(String paramName, String ParamValue) {
        this(paramName, ParamValue, false);

    }

    @Override
    public boolean isSatisfiedBy(HashMap<String,String> candidate) {
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
