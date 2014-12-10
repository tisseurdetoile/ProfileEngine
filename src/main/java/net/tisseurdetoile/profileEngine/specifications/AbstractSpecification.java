/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tisseurdetoile.profileEngine.specifications;

/**
 *
 * @author 11646n
 */
public abstract class AbstractSpecification<E> implements ISpecification<E> {

    /**
     * 
     * @param candidate
     * @return 
     */
    @Override
    public abstract boolean isSatisfiedBy(E candidate);

    @Override
    public ISpecification<E> or(ISpecification<E> otherSpecification) {
        return new OrSpecification<E>(this, otherSpecification);
    }

    @Override
    public ISpecification<E> and(ISpecification<E> otherSpecification) {
        return new AndSpecification<E>(this, otherSpecification);
    }

    @Override
    public ISpecification<E> not() {
        return new NotSpecification<E>(this);
    }
}
