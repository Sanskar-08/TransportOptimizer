package com.example.TransportOptimizer.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private City source;  // This should reference the source city entity

    @ManyToOne
    private City destination;  // This should reference the destination city entity

    private int distance;  // Distance in kilometers
    private int time;  // Time in minutes

    // Constructors, getters, and setters
    public Route() {
    }

    public Route(City source, City destination, int distance, int time) {
        this.source = source;
        this.destination = destination;
        this.distance = distance;
        this.time = time;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public City getSource() {
        return source;
    }

    public void setSource(City source) {
        this.source = source;
    }

    public City getDestination() {
        return destination;
    }

    public void setDestination(City destination) {
        this.destination = destination;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
