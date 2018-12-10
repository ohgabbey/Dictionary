package com.example.oxfordDictionary;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
class Entry {
    private List<Sense> senses;
    private List<String> etymologies;

    public List<Sense> getSenses() {
        return senses;
    }

    public List<String> getEtymologies() {
        return etymologies;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "senses=" + senses +
                ", etymologies=" + etymologies +
                '}';
    }
}
