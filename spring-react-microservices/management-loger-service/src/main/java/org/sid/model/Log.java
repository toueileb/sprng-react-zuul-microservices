package org.sid.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Table(name = "log")
@Entity
public class Log implements IModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "ip")
    private String ip;

    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "log_date")
    private LocalDateTime logDate;
}