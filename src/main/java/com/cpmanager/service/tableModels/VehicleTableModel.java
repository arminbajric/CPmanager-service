package com.cpmanager.service.tableModels;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.time.Year;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name="vehicles")
public class VehicleTableModel implements Serializable {

    @Id
    @Column(name="regPlates")
    String regPlates;
    @Column(name = "manufacturer")
    String manufacturer;
    @Column(name = "commonModels")
    String model;
    @Column(name = "color")
    String color;
    @Column(name="produced")
    Year produced;
    @Column(name = "seats")
    String seats;
    @Column(name = "doors")
    String doors;
    @Column(name = "kilometers")
    int km;
    @Column(name = "load")
    int load;
    @Column(name = "workhours")
    int workhours;
    @Column(name = "nextRegistration")
    Date nextRegistration;
    @Column(name = "nextInsurance")
    Date nextInsurance;
    @Column(name = "nextCleaning")
    Date nextCleaning;
    @Column(name = "nextFullService")
    int nextFullService;
    @Column(name = "nextOafChange")
    int nextOafChange;
    @Column(name = "fuel")
    String fuel;
    @Column(name = "available")
    boolean available;
    @ManyToOne
    @JoinColumn(name = "engine_id")
    EngineTableModel engineTableModel;
    @OneToMany(mappedBy ="vehicleTableModel")
    Set<ReportTableModel> reportTableModelSet=new TreeSet<>();
    @ManyToOne
    @JoinColumn(name = "category_id")
    CategoryTableModel categoryTableModel;
    public String getRegPlates() {
        return regPlates;
    }

    public void setRegPlates(String regPlates) {
        this.regPlates = regPlates;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Year getProduced() {
        return produced;
    }

    public void setProduced(Year produced) {
        this.produced = produced;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getDoors() {
        return doors;
    }

    public void setDoors(String doors) {
        this.doors = doors;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public int getLoad() {
        return load;
    }

    public void setLoad(int load) {
        this.load = load;
    }

    public int getWorkhours() {
        return workhours;
    }

    public void setWorkhours(int workhours) {
        this.workhours = workhours;
    }

    public Date getNextRegistration() {
        return nextRegistration;
    }

    public void setNextRegistration(Date nextRegistration) {
        this.nextRegistration = nextRegistration;
    }

    public Date getNextInsurance() {
        return nextInsurance;
    }

    public void setNextInsurance(Date nextInsurance) {
        this.nextInsurance = nextInsurance;
    }

    public Date getNextCleaning() {
        return nextCleaning;
    }

    public void setNextCleaning(Date nextCleaning) {
        this.nextCleaning = nextCleaning;
    }

    public int getNextFullService() {
        return nextFullService;
    }

    public void setNextFullService(int nextFullService) {
        this.nextFullService = nextFullService;
    }

    public int getNextOafChange() {
        return nextOafChange;
    }

    public void setNextOafChange(int nextOafChange) {
        this.nextOafChange = nextOafChange;
    }

    public EngineTableModel getEngineTableModel() {
        return engineTableModel;
    }

    public void setEngineTableModel(EngineTableModel engineTableModel) {
        this.engineTableModel = engineTableModel;
    }

    public Set<ReportTableModel> getReportTableModelSet() {
        return reportTableModelSet;
    }

    public void setReportTableModelSet(Set<ReportTableModel> reportTableModelSet) {
        this.reportTableModelSet = reportTableModelSet;
    }
}
