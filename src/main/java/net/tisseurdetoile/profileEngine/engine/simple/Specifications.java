/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tisseurdetoile.profileEngine.engine.simple;

import net.tisseurdetoile.profileEngine.engine.simple.specification.AttributeExist;
import net.tisseurdetoile.profileEngine.engine.simple.specification.AttributeValueIs;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author 11646n
 */
public class Specifications {

        public Set<Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet<Class<?>>();
        s.add(AttributeValueIs.class);
        s.add(AttributeExist.class);
        return s;
    }
    
}
