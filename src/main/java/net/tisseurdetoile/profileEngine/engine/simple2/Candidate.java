/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.tisseurdetoile.profileEngine.engine.simple2;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;
import net.tisseurdetoile.profileEngine.cache.ICache;
import net.tisseurdetoile.profileEngine.data.ICandidate;

/**
 *
 * @author TisseurDeToile
 */
public class Candidate implements ICandidate, ICache<UUID> {

    private static final String className = Candidate.class.getName();
    private static final Logger LOG = Logger.getLogger(className);

    private final Map<String, String> datas;
    private final Map<UUID, Boolean> cache;

    public Candidate() {
        this.datas = new HashMap<String, String>();
        this.cache = new HashMap<UUID, Boolean>();
    }

    public Candidate(final Map<String, String> origindata) {
        this.datas = origindata;
        this.cache = new HashMap<UUID, Boolean>();
    }

    @Override
    public boolean containsKey(String key) {
        return this.datas.containsKey(key);
    }

    @Override
    public String get(String key) {
        return datas.get(key);
    }

    @Override
    public void addInCache(UUID uuid, boolean res) {
        final String methodeName = "addInCache";
        LOG.entering(className, methodeName, new Object[]{uuid, res});
        
        this.cache.put(uuid, res);
    }

    @Override
    public boolean getInCache(UUID uuid) {
        final String methodeName = "getInCache";
        
        boolean res = this.cache.get(uuid);
        
        LOG.exiting(className, methodeName, res);
        return res;
    }

    @Override
    public boolean isInCache(UUID uuid) {
        final String methodeName = "isInCache";
        
        boolean res = this.cache.containsKey(uuid);
        
        LOG.exiting(className, methodeName, res);
        return res;
    }

}
