package com.example.TransportOptimizer.service;

import com.example.TransportOptimizer.Entity.City;
import com.example.TransportOptimizer.Entity.Route;
import com.example.TransportOptimizer.Entity.Ticket;
import com.example.TransportOptimizer.repository.CityRepository;
import com.example.TransportOptimizer.repository.RouteRepository;
import com.example.TransportOptimizer.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportService {

    private final CityRepository cityRepository;
    private final RouteRepository routeRepository;
    private final TicketRepository ticketRepository;

    public TransportService(CityRepository cityRepository, RouteRepository routeRepository, TicketRepository ticketRepository) {
        this.cityRepository = cityRepository;
        this.routeRepository = routeRepository;
        this.ticketRepository = ticketRepository;
    }

    public City addCity(City city) {
        return cityRepository.save(city);
    }

    public Route addRoute(Long sourceId, Long destinationId, int distance, int time) {
        // Fetch the City entities using the provided IDs
        City source = cityRepository.findById(sourceId).orElseThrow(() -> new IllegalArgumentException("Source city not found"));
        City destination = cityRepository.findById(destinationId).orElseThrow(() -> new IllegalArgumentException("Destination city not found"));

        // Create a new route
        Route route = new Route(source, destination, distance, time);

        // Save the route to the database
        return routeRepository.save(route);
    }

    private static final double FARE_PER_KM = 1.0;

    public Ticket bookTicket(Long sourceId, Long destinationId) {
        // Fetch the City entities using the provided IDs
        City source = cityRepository.findById(sourceId).orElseThrow(() -> new IllegalArgumentException("Source city not found"));
        City destination = cityRepository.findById(destinationId).orElseThrow(() -> new IllegalArgumentException("Destination city not found"));

        // Fetch the route details for the source and destination
        Route route = routeRepository.findBySourceAndDestination(source, destination);

        if (route == null) {
            throw new IllegalArgumentException("Route not found between the specified cities.");
        }

        // Calculate fare based on the route's distance
        double fare = calculateFare(route.getDistance());

        // Create a new ticket with calculated fare
        Ticket ticket = new Ticket(sourceId, destinationId, fare);

        // Save the ticket to the database
        return ticketRepository.save(ticket);
    }

    private double calculateFare(int distance) {
        return FARE_PER_KM * distance;
    }

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }
}
