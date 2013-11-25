package com.omertron.imdbapi.search;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SearchDeserializer extends StdDeserializer<SearchObject> {

    private final Map<String, Class<? extends SearchObject>> registry = new HashMap<String, Class<? extends SearchObject>>();

    public SearchDeserializer() {
        super(SearchObject.class);
    }

    public void registerSearchObject(String uniqueAttribute, Class<? extends SearchObject> searchClass) {
        registry.put(uniqueAttribute, searchClass);
    }

    @Override
    public SearchObject deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        ObjectMapper mapper = (ObjectMapper) jp.getCodec();
        ObjectNode root = (ObjectNode) mapper.readTree(jp);
        Class<? extends SearchObject> searchClass = null;
        Iterator<Map.Entry<String, JsonNode>> elementsIterator = root.fields();

        while (elementsIterator.hasNext()) {
            Map.Entry<String, JsonNode> element = elementsIterator.next();
            String name = element.getKey();
            System.out.println("Name: " + name + " = " + element.getValue().asText());

            if (registry.containsKey(name)) {
                searchClass = registry.get(name);
                System.out.println("Using class: " + searchClass.getSimpleName());
//                break;
            }
        }

        if (searchClass == null) {
            System.out.println("END: No search class!");
            return new SearchObject();
        }

        SearchObject so = mapper.readValue(jp, searchClass);
        System.out.println("SO: " + so.toString());
        System.out.println("END");
        return so;
    }
}