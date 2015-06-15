/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tisseurdetoile.profileEngine.engine.simple2.specification;

import java.util.UUID;
import net.tisseurdetoile.profileEngine.cache.ICache;
import net.tisseurdetoile.profileEngine.data.ICandidate;
import net.tisseurdetoile.profileEngine.data.DataType;
import net.tisseurdetoile.profileEngine.data.SpecificationScope;
import net.tisseurdetoile.profileEngine.engine.simple2.AbstractHashSpecification;

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
    public boolean isSatisfiedBy(ICandidate candidate) {
        boolean res = false;

        ICache<UUID> cacheData = (ICache<UUID>) candidate;

        if (cacheData.isInCache(this.uuid)) {
            return cacheData.getInCache(this.uuid);
        }

        if (candidate != null) {
            if (this.nullIsEmpty && this.paramValue == null) {
                if (!candidate.containsKey(this.paramName) || (candidate.get(this.paramName) == null)) {
                    res = true;
                    cacheData.addInCache(this.uuid, res);
                    return res;
                }
            }

            if (candidate.containsKey(this.paramName) && this.paramValue != null && this.paramValue.equalsIgnoreCase(candidate.get(this.paramName))) {
                res = true;
                cacheData.addInCache(this.uuid, res);
                return res;
            }

        }

        cacheData.addInCache(this.uuid, res);
        return res;
    }

}
