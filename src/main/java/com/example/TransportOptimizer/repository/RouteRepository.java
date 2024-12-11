package com.example.TransportOptimizer.repository;

import com.example.TransportOptimizer.Entity.Route;
import com.example.TransportOptimizer.Entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route, Long> {
    List<Route> findBySource(City source);
    Route findBySourceAndDestination(City source, City destination);
}
