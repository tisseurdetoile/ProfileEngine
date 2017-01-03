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

        @Override
    public String serialise() {
        StringBuilder sb = new StringBuilder();

        sb.append("OR");
        sb.append("(");
        int ni = 0;

        for (ISpecification<E> iSpecification : specifications) {
            if (ni > 0) {
                sb.append(",");
            }

            sb.append(iSpecification.serialise());

            ni++;
        }

        sb.append(")");

        return sb.toString();

    }
    
}
