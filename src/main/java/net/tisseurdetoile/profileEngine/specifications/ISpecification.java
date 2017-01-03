/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tisseurdetoile.profileEngine.specifications;

/**
 *
 * @author tisseurDeToile
 */
public interface ISpecification<E> {

    public String serialise();
    
    public boolean isSatisfiedBy(E candidate);

    public ISpecification<E> or(ISpecification<E> specification);

    public ISpecification<E> and(ISpecification<E> specification);

    public ISpecification<E> not();
}
