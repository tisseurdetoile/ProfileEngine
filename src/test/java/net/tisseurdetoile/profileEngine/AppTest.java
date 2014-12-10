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
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        HashMap<String,String> testData = new HashMap<String,String>();


        testData.put("nom", "nomdetest");
        testData.put("prenom", "prenomdetest");
        testData.put("ville", "villedetest");
        testData.put("param1", "param1detest");
        testData.put("param2", "param2detest");
        testData.put("param3", "param3detest");


        ISpecification<HashMap<String,String>> sp1 = new AttributeValueIn("nom", "nomdetest");
        ISpecification<HashMap<String,String>> sp2 = new AttributeValueIn("prenom", "prenomdetest");
        ISpecification<HashMap<String,String>> sp3 = new AttributeValueIn("ville", "villedetest");
        ISpecification<HashMap<String,String>> sp4 = new AttributeValueIn("param1", "param1detest");
        ISpecification<HashMap<String,String>> sp5 = new AttributeValueIn("param2", "param2detest");
        ISpecification<HashMap<String,String>> sp6 = new AttributeValueIn("param3", "param3detest");


        ISpecification<HashMap<String,String>> sp7 =  sp6.and(sp1);

        ISpecification<HashMap<String,String>> sp8 = sp7.or(sp1);
        


    }
}
