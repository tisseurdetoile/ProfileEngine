/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tisseurdetoile.profileEngine.engine.simple2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author TisseurDeToile
 */
public class RoleNameFromSpecification {

    protected SpecificationList specList = new SpecificationList();
    protected HashMap<String, List<AbstractHashSpecification>> mapStrSpec = new HashMap<String, List<AbstractHashSpecification>>();

    public RoleNameFromSpecification() {
    }

    public HashMap<String, List<AbstractHashSpecification>> getMapStrSpec() {
        return mapStrSpec;
    }

    public void addSpecification(String name, List<AbstractHashSpecification> specs) {

        if (specs != null && !specs.isEmpty()) {
            List<AbstractHashSpecification> destSpec = new ArrayList<AbstractHashSpecification>();

            Iterator<AbstractHashSpecification> itSpecs = specs.iterator();
            while (itSpecs.hasNext()) {
                AbstractHashSpecification readSpec = itSpecs.next();

                destSpec.add(specList.addSpecification(readSpec));
            }

            mapStrSpec.put(name, destSpec);
        }
    }

    public void addSpecification(String name, AbstractHashSpecification spec) {
        List<AbstractHashSpecification> specs = new ArrayList<AbstractHashSpecification>();

        specs.add(spec);

        addSpecification(name, specs);
    }
}
