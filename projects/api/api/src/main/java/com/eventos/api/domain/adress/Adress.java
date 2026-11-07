package com.eventos.api.domain.adress;

import com.eventos.api.domain.event.Event;
import jakarta.persistence.*;

import java.util.UUID;

@Table(name = "adress")
@Entity
public class Adress {

    @GeneratedValue
    @Id
    private UUID adress_id;

    private String uf;

    private String city;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
}
