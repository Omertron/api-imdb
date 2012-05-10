/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.moviejukebox.imdbapi.model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.deser.StdDeserializer;
import org.codehaus.jackson.node.ObjectNode;

public class SearchDeserializer extends StdDeserializer<SearchObject> {

    private Map<String, Class<? extends SearchObject>> registry = new HashMap<String, Class<? extends SearchObject>>();

    public SearchDeserializer() {
        super(SearchObject.class);
    }

    public void registerSearchObject(String uniqueAttribute,
            Class<? extends SearchObject> searchClass) {
        registry.put(uniqueAttribute, searchClass);
    }

    @Override
    public SearchObject deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ObjectMapper mapper = (ObjectMapper) jp.getCodec();
        ObjectNode root = (ObjectNode) mapper.readTree(jp);
        Class<? extends SearchObject> searchClass = null;
        Iterator<Map.Entry<String, JsonNode>> elementsIterator = root.getFields();
        while (elementsIterator.hasNext()) {
            Map.Entry<String, JsonNode> element = elementsIterator.next();
            String name = element.getKey();
            if (registry.containsKey(name)) {
                searchClass = registry.get(name);
                break;
            }
        }

        if (searchClass == null) {
            return null;
        }

        return mapper.readValue(root, searchClass);
    }
}