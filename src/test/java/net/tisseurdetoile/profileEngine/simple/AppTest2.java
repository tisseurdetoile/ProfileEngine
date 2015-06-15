package net.tisseurdetoile.profileEngine.simple;

import java.util.HashMap;
import java.util.Map;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import net.tisseurdetoile.profileEngine.data.ICandidate;
import net.tisseurdetoile.profileEngine.engine.simple.Candidate;
import net.tisseurdetoile.profileEngine.specifications.ISpecification;
import net.tisseurdetoile.profileEngine.engine.simple.specification.AttributeValueIs;

/**
 * Unit test for simple App.
 */
public class AppTest2
        extends TestCase {

    /**
     *
     */
    private final ISpecification<ICandidate> sp11 = new AttributeValueIs("nom", "nomdetest");
    /**
     *
     */
    private final ISpecification<ICandidate> sp12 = new AttributeValueIs("ville", "villedetest");
    /**
     *
     */
    private final ISpecification<ICandidate> sp21 = new AttributeValueIs("nom", "nomdetest2");
    /**
     *
     */
    private final ISpecification<ICandidate> sp22 = new AttributeValueIs("ville", "villedetest2");

    /**
     *
     */
    private final ISpecification<ICandidate> sp31 = new AttributeValueIs("nom", "nomdetest2");
    /**
     *
     */
    private final ISpecification<ICandidate> sp32 = new AttributeValueIs("ville", "villedetest2");

    /**
     *
     */
    private final ISpecification<ICandidate> sp1X = sp11.and(sp12);
    /**
     *
     */
    private final ISpecification<ICandidate> sp2X = sp21.and(sp22);

    private final ISpecification<ICandidate> sp3X = sp31.and(sp32);

    /**
     * .
     * Create the test case:
     *
     * @param testName name of the test case
     */
    public AppTest2(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest2.class);
    }

    public ICandidate getUser1() {

        Map<String, String> data = new HashMap<String, String>();

        data.put("nom", "nomdetest");
        data.put("prenom", "prenomdetest");
        data.put("ville", "villedetest");

        ICandidate testData = new Candidate(data);

        return testData;
    }

    public ICandidate getUser2() {

        Map<String, String> data = new HashMap<String, String>();

        data.put("nom", "nomdetest2");
        data.put("prenom", "prenomdetest2");
        data.put("ville", "villedetest2");

        ICandidate testData = new Candidate(data);

        return testData;
    }

    /**
     * .
     * Rigourous Test :-)
     */
    public void testSP2U1() {
        ISpecification<ICandidate> sptest2 = sp11.and(sp12).or(sp21).and(sp22);
        assertEquals("sptest2 avec user1", false, sptest2.isSatisfiedBy(getUser1()));

    }

    public void testSP2U2() {
        ISpecification<ICandidate> sptest2 = sp11.and(sp12).or(sp21).and(sp22);
        assertEquals("sptest2 avec user2", true, sptest2.isSatisfiedBy(getUser2()));
    }

    public void testSP1U1() {
        ISpecification<ICandidate> sptest = sp1X.or(sp2X);
        assertEquals("sptest avec user1", true, sptest.isSatisfiedBy(getUser1()));

    }

    public void testSP1U2() {
        ISpecification<ICandidate> sptest = sp1X.or(sp2X);
        assertEquals("sptest avec user2", true, sptest.isSatisfiedBy(getUser2()));
    }

    public void test2SP1U1() {
        ISpecification<ICandidate> sptest = sp1X.or(sp21.and(sp22));
        assertEquals("sptest avec user1", true, sptest.isSatisfiedBy(getUser1()));

    }

    public final void test2SP1U2() {
        ISpecification<ICandidate> sptest = sp1X.or(sp21.and(sp22));
        assertEquals("sptest avec user2", true, sptest.isSatisfiedBy(getUser2()));
    }

    public void test3SP1U1() {
        ISpecification<ICandidate> sptest = sp11.and(sp12).or(sp21.and(sp22));
        assertEquals("sptest avec user1", true, sptest.isSatisfiedBy(getUser1()));

    }

    public void test3SP1U2() {
        ISpecification<ICandidate> sptest = sp11.and(sp12).or(sp21.and(sp22));
        assertEquals("sptest avec user2", true, sptest.isSatisfiedBy(getUser2()));
    }

    public void test3SP2X() {
        assertEquals("sptest avec user2", true, sp2X.isSatisfiedBy(getUser2()));
    }

    public void test3SP3X() {
        assertEquals("sptest avec user2", true, sp3X.isSatisfiedBy(getUser2()));
    }

}
