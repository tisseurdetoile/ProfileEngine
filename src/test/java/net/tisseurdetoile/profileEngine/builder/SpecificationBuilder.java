/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * https://github.com/fasseg/exp4j/blob/master/src/main/java/net/objecthunter/exp4j/tokenizer/Tokenizer.java
 */

package net.tisseurdetoile.profileEngine.builder;

/**
 *
 * @author 11646n
 */
public class SpecificationBuilder {
    private final String specification;

    /**.
     *
     * @param spec chaine de la specification
     */
    public SpecificationBuilder(final String spec) {
        if ((spec == null) || spec.trim().length() == 0) {
            throw new IllegalArgumentException("Specification can not be empty");
        }
        this.specification = spec;
    }



}
