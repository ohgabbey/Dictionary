package com.example.oxfordDictionary;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
class LexicalEntries {
    private List<Entry> entries;

    public List<Entry> getEntries() {
        return entries;
    }

    @Override
    public String toString() {
        return "LexicalEntries{" +
                "entries=" + entries +
                '}';
    }
}
