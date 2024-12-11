package com.example.TransportOptimizer.controller;

import com.example.TransportOptimizer.Entity.City;
import com.example.TransportOptimizer.Entity.Route;
import com.example.TransportOptimizer.Entity.Ticket;
import com.example.TransportOptimizer.service.TransportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transport")
public class TransportController {

    private final TransportService transportService;

    public TransportController(TransportService transportService) {
        this.transportService = transportService;
    }

    @PostMapping("/cities")
    public City addCity(@RequestBody City city) {
        return transportService.addCity(city);
    }

    @PostMapping("/routes")
    public Route addRoute(@RequestParam Long sourceId, @RequestParam Long destinationId, @RequestParam int distance, @RequestParam int time) {
        return transportService.addRoute(sourceId, destinationId, distance, time);
    }

    @PostMapping("/tickets")
    public Ticket bookTicket(@RequestParam Long sourceId, @RequestParam Long destinationId) {
        return transportService.bookTicket(sourceId, destinationId);
    }

    @GetMapping("/cities")
    public List<City> getAllCities() {
        return transportService.getAllCities();
    }

    @GetMapping("/routes")
    public List<Route> getAllRoutes() {
        return transportService.getAllRoutes();
    }

    @GetMapping("/tickets")
    public List<Ticket> getAllTickets() {
        return transportService.getAllTickets();
    }
}
