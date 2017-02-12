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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SearchDeserializer extends StdDeserializer<SearchObject> {

    private static final Logger LOG = LoggerFactory.getLogger(SearchDeserializer.class);
    private final Map<String, Class<? extends SearchObject>> registry = new HashMap<>();

    public SearchDeserializer() {
        super(SearchObject.class);
    }

    public void registerSearchObject(String uniqueAttribute, Class<? extends SearchObject> searchClass) {
        registry.put(uniqueAttribute, searchClass);
    }

    @Override
    public SearchObject deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        LOG.debug("START");
        ObjectMapper mapper = (ObjectMapper) jp.getCodec();
        ObjectNode root = (ObjectNode) mapper.readTree(jp);
        Class<? extends SearchObject> searchClass = null;
        Iterator<Map.Entry<String, JsonNode>> elementsIterator = root.fields();

        LOG.debug("{}", root);

        while (elementsIterator.hasNext()) {
            Map.Entry<String, JsonNode> element = elementsIterator.next();
            String name = element.getKey();
            LOG.debug("Name: {} = {}", name, element.getValue().asText());

            if (registry.containsKey(name)) {
                searchClass = registry.get(name);
                LOG.debug("\tUsing class: {}", searchClass.getSimpleName());
                break;
            }
        }

        if (searchClass == null) {
            LOG.debug("END: No search class!");
            return new SearchObject();
        } else {
            SearchObject so = mapper.readValue(root.toString(), searchClass);
            LOG.debug("SO: {}", so.toString());
            LOG.debug("END");
            return so;
        }
    }
}
