package com.olivar.models;

import javax.persistence.Column;
import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Model extends PanacheEntity{
    public String denomination;
    public boolean onSale;
    @Column(name = "production")
    public int production;
}
