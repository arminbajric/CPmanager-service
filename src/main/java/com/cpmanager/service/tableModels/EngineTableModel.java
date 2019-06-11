package com.cpmanager.service.tableModels;

import org.hibernate.annotations.GenericGenerator;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name = "motors")
public class EngineTableModel implements Serializable {
    @GenericGenerator(name = "engineIdGenerator",strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",parameters =  {
            @org.hibernate.annotations.Parameter(name = "sequence_name", value = "engineSequence"),
            @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
            @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
    })
    @Id
    @GeneratedValue(generator = "engineIdGenerator")
    Long Id;
    @Column(name = "fuel")
    String fuel;
    @Column(name = "mark")
    String mark;
    @Column(name = "horsepower")
    int horsepower;
    @Column(name = "torque")
    int torque;
    @Column(name = "volume")
    int volume;
    @OneToMany(mappedBy = "engineTableModel")
    private Set<VehicleTableModel> vehicleTableModels=new TreeSet<>();

    public Set<VehicleTableModel> getVehicleTableModels() {
        return vehicleTableModels;
    }

    public void setVehicleTableModels(Set<VehicleTableModel> vehicleTableModels) {
        this.vehicleTableModels = vehicleTableModels;
    }

    public Long getId() {
        return Id;
    }
    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public int getTorque() {
        return torque;
    }

    public void setTorque(int torque) {
        this.torque = torque;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
