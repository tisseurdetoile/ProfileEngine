/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tisseurdetoile.profileEngine.specifications;

/**
 *
 * @author 11646n
 */
public class SpecificationScope {
    private final DataType type;
    private final String libelle;
    private final boolean multival;

    public SpecificationScope(final DataType setType, final String setlibelle, final boolean setMultival) {
        this.type = setType;
        this.libelle = setlibelle;
        this.multival = setMultival;
    }

    public SpecificationScope(final DataType setType, final String setlibelle) {
        this(setType, setlibelle, false);
    }

    public final String getLibelle() {
        return libelle;
    }

    public final DataType getType() {
        return type;
    }

    public final boolean getMultival() {
        return multival;
    }
}
