package com.work.shelter.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * The basic entity for the project.
 *
 * @version 1.0
 */

@Entity
@Getter
@Setter
public class Animal {
    @Id
    @SequenceGenerator(
            name = "post_sequence",
            sequenceName = "post_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "post_sequence"
    )
    private Long id;

    @Column(name = "breed")
    private String breed;
    @Column(name = "age")
    private Integer age;
    @Column(name = "sex")
    private String sex;
    @Column(name = "name")
    private String name;
    @Column(name = "info")
    private String info;
    @Column(name = "full_text")
    private String full_text;


    public Animal() {
    }

    public Animal(String breed, Integer age, String sex, String name, String info, String full_text) {
        this.breed = breed;
        this.age = age;
        this.sex = sex;
        this.name = name;
        this.info = info;
        this.full_text = full_text;
    }

}
