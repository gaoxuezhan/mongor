package com.gaoxz.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class ProductsEx implements Serializable {
    private static final long serialVersionUID = -3258839839160856613L;

    private Products target;
    private Map<String,String> detail;

    public Products getTarget() {
        return target;
    }

    public void setTarget(Products target) {
        this.target = target;
    }

    public Map<String, String> getDetail() {
        return detail;
    }

    public void setDetail(Map<String, String> detail) {
        this.detail = detail;
    }
}

