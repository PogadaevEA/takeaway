package com.home.takeaway.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "categories")
@Getter
@Setter
public class Category implements Serializable {

    @Id
    private String id;

    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
}