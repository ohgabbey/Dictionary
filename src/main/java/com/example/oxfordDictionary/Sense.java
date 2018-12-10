package com.example.oxfordDictionary;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Sense {
    private List<String> definitions;

    @JsonProperty("definitions")
    public List<String> getDefinitions() {
        return definitions;
    }

    @Override
    public String toString() {
        return "Sense{" +
                "definitions=" + definitions +
                '}';
    }
}
