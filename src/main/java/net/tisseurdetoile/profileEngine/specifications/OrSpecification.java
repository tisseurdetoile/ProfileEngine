/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tisseurdetoile.profileEngine.specifications;

/**
 *
 * @author tisseurDeToile
 */
public class OrSpecification<E> extends AbstractSpecification<E> {

    private ISpecification<E>[] specifications;

    public OrSpecification(ISpecification<E>... iSpecifications) {
        specifications = iSpecifications;
    }

    @Override
    public boolean isSatisfiedBy(E candidate) {
        boolean result = false;
        for (ISpecification<E> iSpecification : specifications) {
            result |= iSpecification.isSatisfiedBy(candidate);
            if (result) {
                break;
            }
        }
        return result;
    }

}
