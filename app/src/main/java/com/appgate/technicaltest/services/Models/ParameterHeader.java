package com.appgate.technicaltest.services.Models;

public class ParameterHeader {
    private String Key;
    private String Value;

    public ParameterHeader(String key, String value) {
        Key = key;
        Value = value;
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }
}
