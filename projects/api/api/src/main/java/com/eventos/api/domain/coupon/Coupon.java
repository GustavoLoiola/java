package com.eventos.api.domain.coupon;

import com.eventos.api.domain.event.Event;
import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Table(name = "coupon")
@Entity
public class Coupon {

    @GeneratedValue
    @Id
    private UUID coupon_id;

    private Integer descount;

    private String code;

    private Date valid;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
}
