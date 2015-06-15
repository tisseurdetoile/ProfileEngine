/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tisseurdetoile.profileEngine.cache;

/**
 *
 * @author TisseurDeToile
 * @param <E>
 */
public interface ICache<E> {
    /**
     * Ajoute un résultat au cache des résultât
     * @param uuid unique id d'un résultât
     * @param res  résultât à mettre en cache.
     */
    public void addInCache(E uuid, boolean res);
    
    /**
     * Recupere un résultât dans le cache
     * @param uuid unique id d'un résultât
     * @return boolean valeur d'un résltât
     */
    public boolean getInCache(E uuid);
    
    /**
     * Un resultât existe pour l'unique id enregistré.
     * @param uuid
     * @return 
     */
    public boolean isInCache (E uuid);
}
