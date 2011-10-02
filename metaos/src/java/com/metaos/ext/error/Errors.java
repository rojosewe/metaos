/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.metaos.ext.error;

import java.util.*;
import com.metaos.datamgt.*;
import com.metaos.util.*;

/**
 * Collects approximation error information from predictos.
 */
public class Errors {
    private Map<Integer,List<Double>> errors;


    /**
     * Creates a new empty errors management object.
     */
    public Errors() {
        this.errors = new HashMap<Integer, List<Double>>();
    }


    /**
     * Empties memory.
     */
    public void reset() {
        this.errors.clear();
    }


    /**
     * Adds an error notification associated to the prediction at a moment.
     */
    public void addError(final int moment, final double error) {
        List<Double> es = this.errors.get(moment);
        if(es==null) {
            es = new ArrayList<Double>();
        }
        es.add(error);
        this.errors.put(moment, es);
    }


    /**
     * Reports memorized erros associated to a moment.
     */
    public void report(final int moment, final ErrorsStatistics statistics) {
        List<Double> es = this.errors.get(moment);
        if(es!=null) {
            for(final double e : es) {
                statistics.addError(e);
            }
        }
    }


    /**
     * Reports all memorized erros associated to any moment.
     */
    public void report(final ErrorsStatistics statistics) {
        for(final List<Double> es : this.errors.values()) {
            for(final double e : es) {
                statistics.addError(e);
            }
        }
    }

}
