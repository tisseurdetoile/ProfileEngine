package net.tisseurdetoile.profileEngine;

import java.util.HashMap;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import net.tisseurdetoile.profileEngine.specifications.ISpecification;
import net.tisseurdetoile.profileEngine.specifications.hashmap.AttributeValueIn;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {

    /**
     *
     */
    private final ISpecification<HashMap<String, String>> sp11 = new AttributeValueIn("nom", "nomdetest");
    /**
     *
     */
    private final ISpecification<HashMap<String, String>> sp12 = new AttributeValueIn("ville", "villedetest");
    /**
     *
     */
    private final ISpecification<HashMap<String, String>> sp21 = new AttributeValueIn("nom", "nomdetest2");
    /**
     *
     */
    private final ISpecification<HashMap<String, String>> sp22 = new AttributeValueIn("ville", "villedetest2");
    /**
     *
     */
    private final ISpecification<HashMap<String, String>> sp1X = sp11.and(sp12);
    /**
     *
     */
    private final ISpecification<HashMap<String, String>> sp2X = sp21.and(sp22);

    /**.
     * Create the test case:
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    public HashMap<String, String> getUser1() {
        HashMap<String, String> testData = new HashMap<String, String>();

        testData.put("nom", "nomdetest");
        testData.put("prenom", "prenomdetest");
        testData.put("ville", "villedetest");

        return testData;
    }

    public HashMap<String, String> getUser2() {
        HashMap<String, String> testData = new HashMap<String, String>();

        testData.put("nom", "nomdetest2");
        testData.put("prenom", "prenomdetest2");
        testData.put("ville", "villedetest2");

        return testData;
    }

    /**.
     * Rigourous Test :-)
     */
    public void testSP2U1() {
        ISpecification<HashMap<String, String>> sptest2 = sp11.and(sp12).or(sp21).and(sp22);
        assertEquals("sptest2 avec user1", false, sptest2.isSatisfiedBy(getUser1()));

    }

    public void testSP2U2() {
        ISpecification<HashMap<String, String>> sptest2 = sp11.and(sp12).or(sp21).and(sp22);
        assertEquals("sptest2 avec user2", true, sptest2.isSatisfiedBy(getUser2()));
    }

    public void testSP1U1() {
        ISpecification<HashMap<String, String>> sptest = sp1X.or(sp2X);
        assertEquals("sptest avec user1", true, sptest.isSatisfiedBy(getUser1()));

    }

    public void testSP1U2() {
        ISpecification<HashMap<String, String>> sptest = sp1X.or(sp2X);
        assertEquals("sptest avec user2", true, sptest.isSatisfiedBy(getUser2()));
    }

    public void test2SP1U1() {
        ISpecification<HashMap<String, String>> sptest = sp1X.or(sp21.and(sp22));
        assertEquals("sptest avec user1", true, sptest.isSatisfiedBy(getUser1()));

    }

    public final void test2SP1U2() {
        ISpecification<HashMap<String, String>> sptest = sp1X.or(sp21.and(sp22));
        assertEquals("sptest avec user2", true, sptest.isSatisfiedBy(getUser2()));
    }

    public void test3SP1U1() {
        ISpecification<HashMap<String, String>> sptest = sp11.and(sp12).or(sp21.and(sp22));
        assertEquals("sptest avec user1", true, sptest.isSatisfiedBy(getUser1()));

    }

    public void test3SP1U2() {
        ISpecification<HashMap<String, String>> sptest = sp11.and(sp12).or(sp21.and(sp22));
        assertEquals("sptest avec user2", true, sptest.isSatisfiedBy(getUser2()));
    }
}
