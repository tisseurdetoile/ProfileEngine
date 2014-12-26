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
public class AttributeExist extends AbstractSpecification<HashMap<String, String>> {
    
    public static final SpecificationScope SCOPE = new SpecificationScope(DataType.String, "L'attribut existe");

    private String paramName;
    private String paramValue;
    private boolean nullIsEmpty;

    public AttributeExist(String name, String value, boolean nullIsEmpty) {
        this.paramName = name;
        this.paramValue = value;
        this.nullIsEmpty = nullIsEmpty;
    }

    /**
     * @param name nom de l'attribut
     * @param value valeur attendu
     */
    public AttributeExist(final String name, final String value) {
        this(name, value, false);

    }

    @Override
    public boolean isSatisfiedBy(HashMap<String,String> candidate) {
        if (candidate != null) {
            if (candidate.containsKey(this.paramName)) {
                return true;
            }

        }
        return false;
    }
}
