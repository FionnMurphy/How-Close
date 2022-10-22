package com.example.HowClose;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Component
public class AsteroidClient {
    private final WebClient client;

    public AsteroidClient(WebClient.Builder builder){
        this.client = builder.baseUrl("https://api.nasa.gov/neo/rest/v1").build();
    }

    //TODO: Research Mono and Flux
    public List<Asteroid> getAsteroids() throws IOException {
        LocalDate date = LocalDate.now().minusDays(1);

        String json = this.client
                .get()
                .uri("/feed?start_date=" + date + "&end_date=" + date + "&api_key=zKyPE2cQZEQzQ4W5Grxv4PJZVv4iE80gSMmA01qp")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        System.out.println(json);

        //deserialize

        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        // read response as a tree model
        final JsonNode response = mapper.readTree(json).path("near_earth_objects").path(date.toString());
        // create collection type
        final CollectionType collectionType = TypeFactory.defaultInstance().constructCollectionType(List.class, Asteroid.class);

        //convert tree model to collection
        return mapper.readerFor(collectionType).readValue(response);
    }
}
