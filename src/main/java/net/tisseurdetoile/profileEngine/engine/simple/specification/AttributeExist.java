/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tisseurdetoile.profileEngine.engine.simple.specification;

import java.util.HashMap;
import net.tisseurdetoile.profileEngine.data.ICandidate;
import net.tisseurdetoile.profileEngine.engine.simple.AbstractHashSpecification;
import net.tisseurdetoile.profileEngine.data.DataType;

/**
 *
 * @author 11646n
 */
public class AttributeExist extends AbstractHashSpecification {

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

    public AttributeExist(final String name) {
        this(name, null);
    }

    @Override
    public boolean isSatisfiedBy(ICandidate candidate) {
        if (candidate != null) {
            if (candidate.containsKey(this.paramName)) {
                return true;
            }

        }
        return false;
    }
}
