package com.roma_n_ibragim.store.models;


import jakarta.persistence.*;
import lombok.*;

import java.time.Duration;
import java.time.Instant;

/**
 * @author Roma
 */

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @Column(nullable = false)
    private Instant startTime;
    @Column(nullable = false)
    private Instant endTime;

    private boolean donat;
    private int money;

    public Duration getDuration(){
        return Duration.between(startTime,endTime);
    }

}
