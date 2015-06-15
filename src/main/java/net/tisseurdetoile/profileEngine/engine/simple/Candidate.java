/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tisseurdetoile.profileEngine.engine.simple;

import java.util.HashMap;
import java.util.Map;
import net.tisseurdetoile.profileEngine.data.ICandidate;

/**
 *
 * @author TisseurDeToile
 */
public class Candidate implements ICandidate {
        private final Map<String, String> datas;

    public Candidate() {
        this.datas = new HashMap<String, String>();
    }
        
    public Candidate(final Map<String, String> origindata) {
        this.datas = origindata;
    }
    
        @Override
    public boolean containsKey(String key) {
        return this.datas.containsKey(key);
    }
        
        @Override
    public String get (String key) {
        return datas.get(key);
    }
}
