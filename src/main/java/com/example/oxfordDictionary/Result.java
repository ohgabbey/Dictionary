package com.example.oxfordDictionary;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {
    private String id;
    private List<LexicalEntries> lexicalEntries;

    public String getId() {
        return id;
    }

    @JsonProperty("lexicalEntries")
    public List<LexicalEntries> getLexicalEntries() {
        return lexicalEntries;
    }

    @Override
    public String toString() {
        return "Result{" +
                "id='" + id + '\'' +
                ", lexicalEntries=" + lexicalEntries +
                '}';
    }
}
