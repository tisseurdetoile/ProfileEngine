/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tisseurdetoile.profileEngine.engine.simple2.specification;

import java.util.UUID;
import net.tisseurdetoile.profileEngine.cache.ICache;
import net.tisseurdetoile.profileEngine.engine.simple2.AbstractHashSpecification;
import net.tisseurdetoile.profileEngine.data.DataType;
import net.tisseurdetoile.profileEngine.data.ICandidate;
import net.tisseurdetoile.profileEngine.data.SpecificationScope;

/**
 *
 * @author 11646n
 */
public class AttributeExist extends AbstractHashSpecification {

    public static final SpecificationScope SCOPE = new SpecificationScope(DataType.None, "La valeur existe :");
    
    public AttributeExist(String name, String value, boolean nullIsEmpty) {
        this.type = DataType.None;
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
        boolean res = false;
        
        ICache<UUID> cacheData = (ICache<UUID>) candidate;
        
        if (cacheData.isInCache(this.uuid)) {
            return cacheData.getInCache(this.uuid);
        }
        
        if (candidate != null) {
            if (candidate.containsKey(this.paramName)) {
                res = true;
            }
        }
        
        cacheData.addInCache(this.uuid, res);
        return res;
    }
}
