/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tisseurdetoile.profileEngine.specifications;

/**
 * @param <E>
 * @author 11646n
 */
public abstract class AbstractSpecification<E> implements ISpecification<E> {

    /**
     *
     * @param candidate �l�ment a verifier
     * @return vrai si les condition sont satisfaite
     */
    @Override
    public abstract boolean isSatisfiedBy(E candidate);

    @Override
    public abstract String serialise();
    
    @Override
    public final ISpecification<E> or(final ISpecification<E> otherSpecification) {
        return new OrSpecification<E>(this, otherSpecification);
    }

    @Override
    public final ISpecification<E> and(final ISpecification<E> otherSpecification) {
        return new AndSpecification<E>(this, otherSpecification);
    }

    @Override
    public final ISpecification<E> not() {
        return new NotSpecification<E>(this);
    }
    
    
}
