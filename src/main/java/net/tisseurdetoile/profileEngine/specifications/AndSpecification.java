/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tisseurdetoile.profileEngine.specifications;

/**
 *
 * @author tisseurDeToile
 */
public class AndSpecification<E> extends AbstractSpecification<E> {

    private ISpecification<E>[] specifications;

    public AndSpecification(ISpecification<E>...iSpecifications) {
        specifications = iSpecifications;
    }

    @Override
    public boolean isSatisfiedBy(E candidate) {
        boolean result = true;
        for (ISpecification<E> iSpecification : specifications) {
            result &= iSpecification.isSatisfiedBy(candidate);
            if (!result) {
                break;
            }
        }
        return result;
    }
}
