package com.example.HowClose;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = AsteroidDeserializer.class)
public class Asteroid {
    private final String id;
    private final String name;
    private final boolean is_potentially_hazardous_asteroid;
    private final double estimated_diameter_max;
    private final String close_approach_date_full;
    private final double kilometers_per_second;
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
