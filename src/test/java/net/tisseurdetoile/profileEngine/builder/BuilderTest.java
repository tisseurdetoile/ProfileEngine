/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * https://stackoverflow.com/questions/2206378/how-to-split-a-string-but-also-keep-the-delimiters
 */

package net.tisseurdetoile.profileEngine.builder;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author 11646n
 */
public class BuilderTest {
    /**
     *
     * @return une specification Simple.
     */
    public final String getSimpleSpecification() {
        String strSpec = "[IsValorisedAttribute:nom].AND[IsAttributeValueIn:nom:Test]";

        return strSpec;
    }

    /**
     *
     * @return une specification Simple.
     */
    public final String getSpecification() {
        String strSpec = "([IsValorisedAttribute:nom].AND[IsAttributeValueIn:nom:Test]).OR([IsValorisedAttribute:nom].AND[IsAttributeValueIn:nom:Test2])";

        return strSpec;
    }

    public void test1() {
        String test = getSpecification();


        System.out.println(test);

        String[] artest = test.split("\\.|((?<=\\()|(?=\\())|((?<=\\))|(?=\\)))|((?<=\\[)|(?=\\[))|((?<=\\])|(?=\\]))");

     List<String> wordList = Arrays.asList(artest);


     System.out.println (wordList);
    }


}
