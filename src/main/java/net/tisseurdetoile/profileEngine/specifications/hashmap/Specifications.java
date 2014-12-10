/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tisseurdetoile.profileEngine.specifications.hashmap;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author 11646n
 */
public class Specifications {

        public Set<Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet<Class<?>>();
        s.add(AttributeValueIn.class);
        return s;
    }
    
}
