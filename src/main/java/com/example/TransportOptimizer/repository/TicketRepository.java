package com.example.TransportOptimizer.repository;

import com.example.TransportOptimizer.Entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
