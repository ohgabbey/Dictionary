package com.example.oxfordDictionary;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
class DictionaryFields {

    @JsonProperty("results")
    public void getResults(List<Result> results) {
        Result result = results.get(0);
        List<LexicalEntries> lexicalEntriesList = result.getLexicalEntries();
        LexicalEntries lexicalEntries = lexicalEntriesList.get(0);
        String id = result.getId();
        System.out.println("\nWord: " + id);
        List<Entry> entryList = lexicalEntries.getEntries();
        entryList.forEach( entry -> {
            System.out.println("\nEtymology: ");
            System.out.print("\t\u2022 " + entry.getEtymologies().toString().replace("[", "").replace("]", ""));
            System.out.println("\nDefinition: ");
            entry.getSenses().forEach( sense -> {
                System.out.println("\t\u2022 " + sense.getDefinitions().toString().replace("[", "").replace("]", ""));
            });
        } );
    }
}