package net.tisseurdetoile.profileEngine;

import java.util.HashMap;
import java.util.Map;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import net.tisseurdetoile.profileEngine.data.Candidate;
import net.tisseurdetoile.profileEngine.specifications.ISpecification;
import net.tisseurdetoile.profileEngine.engine.simple.SpecificationList;
import net.tisseurdetoile.profileEngine.engine.simple.specification.AttributeValueIs;

/**
 * Unit test for simple App.
 */
public class AppTest1
        extends TestCase {

    public SpecificationList specList = new SpecificationList();

    /**
     *
     */
    private final ISpecification<Candidate> sp11 = specList.addSpecification(new AttributeValueIs("nom", "nomdetest"));
    /**
     *
     */
    private final ISpecification<Candidate> sp12 = specList.addSpecification(new AttributeValueIs("ville", "villedetest"));
    /**
     *
     */
    private final ISpecification<Candidate> sp21 = specList.addSpecification(new AttributeValueIs("nom", "nomdetest2"));
    /**
     *
     */
    private final ISpecification<Candidate> sp22 = specList.addSpecification(new AttributeValueIs("ville", "villedetest2"));

    /**
     *
     */
    private final ISpecification<Candidate> sp31 = specList.addSpecification(new AttributeValueIs("nom", "nomdetest2"));
    /**
     *
     */
    private final ISpecification<Candidate> sp32 = specList.addSpecification(new AttributeValueIs("ville", "villedetest2"));

    /**
     *
     */
    private final ISpecification<Candidate> sp1X = sp11.and(sp12);
    /**
     *
     */
    private final ISpecification<Candidate> sp2X = sp21.and(sp22);

    private final ISpecification<Candidate> sp3X = sp31.and(sp32);

    /**
     * .
     * Create the test case:
     *
     * @param testName name of the test case
     */
    public AppTest1(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest1.class);
    }

    public Candidate getUser1() {
        Candidate testData = new Candidate();

        Map<String, String> data = new HashMap<String, String>();

        data.put("nom", "nomdetest");
        data.put("prenom", "prenomdetest");
        data.put("ville", "villedetest");

        testData.putAll(data);

        return testData;
    }

    public Candidate getUser2() {
        Candidate testData = new Candidate();

        Map<String, String> data = new HashMap<String, String>();

        data.put("nom", "nomdetest2");
        data.put("prenom", "prenomdetest2");
        data.put("ville", "villedetest2");

        testData.putAll(data);

        return testData;
    }

    /**
     * .
     * Rigourous Test :-)
     */
    public void testSPinit() {
        System.out.println(String.format("Size %s", specList.size()));
    }

    /**
     * .
     * Rigourous Test :-)
     */
    public void testSP2U1() {
        ISpecification<Candidate> sptest2 = sp11.and(sp12).or(sp21).and(sp22);
        assertEquals("sptest2 avec user1", false, sptest2.isSatisfiedBy(getUser1()));

    }

    public void testSP2U2() {
        ISpecification<Candidate> sptest2 = sp11.and(sp12).or(sp21).and(sp22);
        assertEquals("sptest2 avec user2", true, sptest2.isSatisfiedBy(getUser2()));
    }

    public void testSP1U1() {
        ISpecification<Candidate> sptest = sp1X.or(sp2X);
        assertEquals("sptest avec user1", true, sptest.isSatisfiedBy(getUser1()));

    }

    public void testSP1U2() {
        ISpecification<Candidate> sptest = sp1X.or(sp2X);
        assertEquals("sptest avec user2", true, sptest.isSatisfiedBy(getUser2()));
    }

    public void test2SP1U1() {
        ISpecification<Candidate> sptest = sp1X.or(sp21.and(sp22));
        assertEquals("sptest avec user1", true, sptest.isSatisfiedBy(getUser1()));

    }

    public final void test2SP1U2() {
        ISpecification<Candidate> sptest = sp1X.or(sp21.and(sp22));
        assertEquals("sptest avec user2", true, sptest.isSatisfiedBy(getUser2()));
    }

    public void test3SP1U1() {
        ISpecification<Candidate> sptest = sp11.and(sp12).or(sp21.and(sp22));
        assertEquals("sptest avec user1", true, sptest.isSatisfiedBy(getUser1()));

    }

    public void test3SP1U2() {
        ISpecification<Candidate> sptest = sp11.and(sp12).or(sp21.and(sp22));
        assertEquals("sptest avec user2", true, sptest.isSatisfiedBy(getUser2()));
    }

    public void test3SP2X() {
        assertEquals("sptest avec user2", true, sp2X.isSatisfiedBy(getUser2()));
    }

    public void test3SP3X() {
        assertEquals("sptest avec user2", true, sp3X.isSatisfiedBy(getUser2()));
    }

}
