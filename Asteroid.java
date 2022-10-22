package com.example.HowClose;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = AsteroidDeserializer.class)
public class Asteroid {
    @JsonProperty("id")
    private final String id;
    @JsonProperty("name")
    private final String name;
    @JsonProperty("is_potentially_hazardous_asteroid")
    private final boolean is_potentially_hazardous_asteroid;
    @JsonProperty("estimated_diameter_max")
    private final double estimated_diameter_max;
    @JsonProperty("close_approach_date_full")
    private final String close_approach_date_full;
    @JsonProperty("kilometers_per_second")
    private final double kilometers_per_second;
    @JsonProperty("miss_distance_lunar")
    private final double miss_distance_lunar;

    @JsonCreator
    public Asteroid(final String id, final String name, final boolean is_potentially_hazardous_asteroid, final double estimated_diameter_max, final String close_approach_date_full, final double kilometers_per_second, final double miss_distance_lunar){
        this.id = id;
        this.name = name;
        this.is_potentially_hazardous_asteroid = is_potentially_hazardous_asteroid;
        this.estimated_diameter_max = estimated_diameter_max;
        this.close_approach_date_full = close_approach_date_full;
        this.kilometers_per_second = kilometers_per_second;
        this.miss_distance_lunar = miss_distance_lunar;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isIs_potentially_hazardous_asteroid() {
        return is_potentially_hazardous_asteroid;
    }

    public double getEstimated_diameter_max() {
        return estimated_diameter_max;
    }

    public String getClose_approach_date_full() {
        return close_approach_date_full;
    }

    public double getKilometers_per_second() {
        return kilometers_per_second;
    }

    public double getMiss_distance_lunar() {
        return miss_distance_lunar;
    }

    @Override
    public String toString() {
        return "Asteroid{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", is_potentially_hazardous_asteroid=" + is_potentially_hazardous_asteroid +
                ", estimated_diameter_max=" + estimated_diameter_max +
                ", close_approach_date_full='" + close_approach_date_full + '\'' +
                ", kilometers_per_second=" + kilometers_per_second +
                ", miss_distance_lunar=" + miss_distance_lunar +
                '}';
    }
}
