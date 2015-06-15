/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tisseurdetoile.profileEngine.engine.simple;

import net.tisseurdetoile.profileEngine.data.DataType;
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
    protected boolean nullIsEmpty;

    public AbstractHashSpecification() {
    }    
}
