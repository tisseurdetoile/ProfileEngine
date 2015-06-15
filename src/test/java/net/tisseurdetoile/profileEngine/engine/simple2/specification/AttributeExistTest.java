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
package net.tisseurdetoile.profileEngine.engine.simple2.specification;

import java.util.HashMap;
import java.util.Map;
import junit.framework.TestCase;
import net.tisseurdetoile.profileEngine.data.ICandidate;
import net.tisseurdetoile.profileEngine.engine.simple2.AbstractHashSpecification;
import net.tisseurdetoile.profileEngine.engine.simple2.Candidate;

/**
 *
 * @author TisseurDeToile
 */
public class AttributeExistTest extends TestCase {
    
    public AttributeExistTest(String testName) {
        super(testName);
    }

    public void testIsSatisfiedBy() {
        System.out.println("testisSatisfiedBy");

        String param = "name";
        String value = "value";

        Map<String, String> testData = new HashMap<String, String>();

        testData.put(param, value);

        AbstractHashSpecification spec = new AttributeExist(param);

        ICandidate candidate = new Candidate(testData);

        assertTrue(spec.isSatisfiedBy(candidate));

    }

    public void testNotIsSatisfiedBy() {
        System.out.println("testisSatisfiedBy");

        String param = "name";
        String value = "value";
        String paramDiff = "shortName";

        Map<String, String> testData = new HashMap<String, String>();

        testData.put(param, value);

        AbstractHashSpecification spec = new AttributeExist(paramDiff);

        ICandidate candidate = new Candidate(testData);

        assertFalse(spec.isSatisfiedBy(candidate));

    }
    
        public void testEquals() {
        System.out.println("testEquals");

        AbstractHashSpecification spec = new AttributeExist("nom");
        AbstractHashSpecification spec2 = new AttributeExist("nom");

        assertTrue(spec.equals(spec2));
    }

}
