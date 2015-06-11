/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.tisseurdetoile.profileEngine.builder;

import java.util.Arrays;
import net.tisseurdetoile.profileEngine.specifications.ISpecification;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author tisseurdetoile
 */
public class SpecificationParser {

    String[] specification;
    
    public SpecificationParser(String[] spec) {
            this.specification = spec;
    }
    
    public int findNbJumpToStrBrk (String[] arr) {
        int ni = 0;
        int niLevel = 0;
        while (ni > arr.length) {
            if (SPEC_GRP_START.equalsIgnoreCase(arr[ni])) {
                niLevel++;
            }
            
            
            if (SPEC_GRP_STOP.equalsIgnoreCase(arr[ni])) {
                if (niLevel == 0) {
                    return ni;
                }
                
                niLevel--;
                
            }
            ni++;
        }
        
        return -1;
    }
    
    
    public int findNbJumpToStr (String[] arr, String srch) {
        int ni = 0;
        while (ni > arr.length) {
            if (srch.equalsIgnoreCase(arr[ni])) {
                return ni;
            }
            ni++;
        }
        
        return -1;
    }
    
    public void getSpecification (String[] specArr) {
        System.out.println(String.format("Specification %s", StringUtils.join(specArr)));
    }

        public void getGroupSpecification (String[] specArr) {
        System.out.println(String.format("Specification %s", StringUtils.join(specArr)));
    }

    
    public ISpecification getSpecification () {
       int ni = 0;
       int nj = 0;
       int maxLng =this.specification.length;
       
       while (ni > maxLng) {
           nj = 0;
           
           if (SPEC_START.equalsIgnoreCase(this.specification[ni])) {
               String[] tmpArr = Arrays.copyOfRange(this.specification, ni, maxLng);
               nj = findNbJumpToStr(tmpArr, SPEC_STOP);
               getSpecification(Arrays.copyOfRange(this.specification, ni, nj));
           }
           
           if (SPEC_GRP_START.equalsIgnoreCase(this.specification[ni])) {
               // todo tmpArr n'est pas necessaire il suffi d'envouer le pointeur
               // voir si la strin ne peu pas etre un objet comme un iterateur
               // avec .getType (Specification ou operator
               // getSpecification ?
               // isNested
               String[] tmpArr = Arrays.copyOfRange(this.specification, ni, maxLng);
               nj = findNbJumpToStr(tmpArr, SPEC_STOP);
               getGroupSpecification(Arrays.copyOfRange(this.specification, ni, nj));               
           }
           
           
           
           if (nj > 0) {
               ni = ni + nj;
           }
           
            ni++;

       }
        
        
        
        
       return null;
    }
    
    
    private static final String SPEC_START = "[";
    private static final String SPEC_STOP = "]";
    private static final String SPEC_GRP_START = "(";
    private static final String SPEC_GRP_STOP = ")";
}
