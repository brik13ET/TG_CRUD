package com.roma_n_ibragim.store.models;


import jakarta.persistence.*;
import lombok.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.TimeZone;

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

    @Transient
    private final TimeZone tz =TimeZone.getTimeZone("Europe/Samara");
    @Transient
    private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @Column(nullable = false)
    private Date startTime;
    @Column(nullable = false)
    private Date endTime;

    private boolean donat;
    private int money;

    public Duration getDuration(){
        return Duration.between(startTime.toInstant(),
                endTime.toInstant());
    }

    {
        dateFormat.setLenient(false);
        dateFormat.setTimeZone(tz);
    }

}
