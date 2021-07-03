package com.launchacademy.javaspringdata.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "app_categories")
@Getter
@Setter
public class AppCategory {
@Id
@SequenceGenerator(name="app_category_generator",sequenceName="app_categories_id_seq", allocationSize = 1)
@GeneratedValue(strategy= GenerationType.SEQUENCE,generator="app_category_generator")
@Column(name="id", nullable=false, unique=true)
private Long id;

@NotEmpty
@Column(name="name", nullable=false)
private String name;
}
