/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tisseurdetoile.profileEngine.data;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author TisseurDeToile
 */
public class Candidate {
    private final HashMap<String, String> datas;

    public Candidate() {
        this.datas = new HashMap<String, String>();
    }
    
    public boolean containsKey(String key) {
        return this.datas.containsKey(key);
    }
    
    public void putAll ( Map<String, String> origindata) {
        this.datas.putAll(origindata);
    }
    
    public String get (String key) {
        return datas.get(key);
    }
    
}
