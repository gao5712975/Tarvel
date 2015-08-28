package com.tarvel.basic.page;

import java.util.List;

/**
 * Created by Yuan on 2015/7/13 0013.
 */
public class Page<T> {
    private int total;
    private List<T> results;
    private int firstResult;
    private int maxResults;

    public Page() {
    }

    public Page(int total, List<T> results) {
        this.total = total;
        this.results = results;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public int getFirstResult() {
        return firstResult;
    }

    public void setFirstResult(int firstResult) {
        this.firstResult = firstResult;
    }

    public int getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(int maxResults) {
        this.maxResults = maxResults;
    }
}
