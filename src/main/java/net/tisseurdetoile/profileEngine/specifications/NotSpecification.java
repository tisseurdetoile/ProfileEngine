/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tisseurdetoile.profileEngine.specifications;

/**
 *
 * @author tisseurDeToile
 */
public class NotSpecification<E> extends AbstractSpecification<E> {

    private ISpecification<E> specification;

    public NotSpecification(ISpecification<E> iSpecification) {
        specification = iSpecification;
    }

    @Override
    public boolean isSatisfiedBy(E candidate) {
        return !specification.isSatisfiedBy(candidate);
    }

        @Override
    public String serialise() {
        StringBuilder sb = new StringBuilder();

        sb.append(specification.serialise());
        sb.append(".NOT");

        return sb.toString();

    }
    
}
