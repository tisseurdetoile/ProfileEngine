/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tisseurdetoile.profileEngine.engine.simple2;

import net.tisseurdetoile.profileEngine.data.DataType;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;
import net.tisseurdetoile.profileEngine.data.ICandidate;
import net.tisseurdetoile.profileEngine.specifications.*;

/**
 * @author 11646n
 */
public abstract class AbstractHashSpecification extends AbstractSpecification<ICandidate> {
    
    protected DataType type;
    protected String paramName;
    protected String paramValue;
    protected List<String> paramValues;
    protected boolean nullIsEmpty;
    protected UUID uuid;

    public AbstractHashSpecification() {
        this.uuid = UUID.randomUUID();
    }

    public UUID getUuid() {
        return uuid;
    }

    public boolean equals(AbstractHashSpecification spec) {

        if (!this.type.equals(spec.type)) {
            return false;
        }

        if (!this.paramName.equals(spec.paramName)) {
            return false;
        }

        if (this.nullIsEmpty != spec.nullIsEmpty) {
            return false;
        }

        if (DataType.String == this.type) {
            return (this.paramValue.equals(spec.paramValue));
        }

        if (DataType.List == this.type) {
            return (this.paramValues.equals(spec.paramValues));
        }

        return true;
    }
}
