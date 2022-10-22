package com.example.HowClose;

import java.util.ArrayList;

public class Asteroids {
    private static ArrayList<Asteroid> asteroids = new ArrayList<>();

    public static void add(Asteroid asteroid){
        asteroids.add(asteroid);
    }

    public static ArrayList<Asteroid> getAsteroids() {
        return asteroids;
    }
}
