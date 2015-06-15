/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tisseurdetoile.profileEngine.data;

/**
 * 
 * 
 * @author TisseurDeToile
 */
public interface ICandidate {

    /**
     * 
     * @param key 
     * @return boolean 
     */
    public boolean containsKey(String key);

    /**
     * 
     * @param key
     * @return String 
     */
    public String get (String key);
    
}
