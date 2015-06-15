/*
 * Copyright (C) 2015 TisseurDeToile
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.tisseurdetoile.profileEngine.engine.simple2;

import junit.framework.TestCase;
import net.tisseurdetoile.profileEngine.engine.simple2.specification.AttributeValueIs;

/**
 *
 * @author TisseurDeToile
 */
public class SpecificationListTest extends TestCase {

    public SpecificationListTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of getSameSpecification method, of class SpecificationList.
     *
     * @param spec
     * @param spec2
     */
    public void GetSameSpecification(AbstractHashSpecification spec, AbstractHashSpecification spec2) {
        System.out.println("getSameSpecification");

        SpecificationList instance = new SpecificationList();
        instance.addSpecification(spec);

        AbstractHashSpecification newSp = instance.getSameSpecification(spec2);

        System.out.println(String.format("spec.uuid = %s newSp = %s spec2.uuid = %s", spec.uuid, newSp.uuid, spec2.uuid));
        assertEquals(newSp.uuid, spec.uuid);
    }

    /**
     * Test of getSameSpecification method, of class SpecificationList.
     */
    public void testGetSameSpecification() {
        System.out.println("getSameSpecification");
        AbstractHashSpecification spec = new AttributeValueIs("nom", "nomdetest");
        AbstractHashSpecification spec2 = new AttributeValueIs("nom", "nomdetest");

        GetSameSpecification(spec, spec2);
    }

    /**
     * Test of getSameSpecification method, of class SpecificationList.
     *
     * @TODO ajouter le test public void testGetSameSpecificationList() {
     * System.out.println("getSameSpecification");
     *
     * List<String> strings = Arrays.asList(new String[]{"one", "two",
     * "three"}); List<String> strings2 = Arrays.asList(new String[]{"one",
     * "three", "two"});
     *
     * AbstractHashSpecification spec = new AttributeValueIs("nom", strings);
     * AbstractHashSpecification spec2 = new AttributeValueIs("nom", strings2);
     *
     * GetSameSpecification (spec, spec2); }
     */
    public void testMain() {
        System.out.println("testMain");

        AbstractHashSpecification sp = new AttributeValueIs("nom", "nomdetest");
        AbstractHashSpecification sp2 = new AttributeValueIs("nom", "nomdetest");

        SpecificationList instance = new SpecificationList();

        AbstractHashSpecification newSp = instance.addSpecification(sp);

        assertEquals(newSp.uuid, sp.uuid);

    }

}
