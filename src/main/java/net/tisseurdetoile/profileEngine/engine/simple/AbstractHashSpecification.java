/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tisseurdetoile.profileEngine.engine.simple;

import java.util.List;
import net.tisseurdetoile.profileEngine.data.ICandidate;
import net.tisseurdetoile.profileEngine.specifications.*;

/**
 * @author 11646n
 */
public abstract class AbstractHashSpecification extends AbstractSpecification<ICandidate> {

    protected String paramName;
    protected String paramValue;
    protected List<String> paramValues;
    protected boolean nullIsEmptyOrZero;

    public AbstractHashSpecification() {
    }

    @Override
    public String serialise() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        sb.append(this.getClass().getSimpleName());
        sb.append(":");
        sb.append(this.paramName);
        sb.append(":");

        if (this.paramValue != null) {
            sb.append(this.paramValue);
        }

        if (this.paramValues != null) {
            sb.append(this.paramValues);
        }

        sb.append("]");

        return sb.toString();
    }

}
