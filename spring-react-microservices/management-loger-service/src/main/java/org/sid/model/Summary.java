package org.sid.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "summary")
@Entity
public class Summary implements IModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long courseId;


//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long hitCount;
}