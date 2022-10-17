package com.example.HowClose;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class AsteroidDeserializer extends StdDeserializer<Asteroid>{
    public AsteroidDeserializer(){
        this(null);
    }
    public AsteroidDeserializer(Class<?> vc){
        super(vc);
    }

    @Override
    public Asteroid deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException{
        JsonNode node = jp.getCodec().readTree(jp);

        String id = node.get("id").asText();
        String name = node.get("name").asText();
        boolean is_potentially_hazardous_asteroid = node.get("is_potentially_hazardous_asteroid").asBoolean();
        double estimated_diameter_max = node.get("estimated_diameter").get("meters").get("estimated_diameter_max").asDouble();

        JsonNode close_approach_data = node.get("close_approach_data").get(0);

        String close_approach_date_full = close_approach_data.get("close_approach_date_full").asText();
        double kilometers_per_second = close_approach_data.get("relative_velocity").get("kilometers_per_second").asDouble();
        double miss_distance_lunar = close_approach_data.get("miss_distance").get("lunar").asDouble();

        return new Asteroid( id, name, is_potentially_hazardous_asteroid, estimated_diameter_max, close_approach_date_full, kilometers_per_second, miss_distance_lunar);
    }
}
