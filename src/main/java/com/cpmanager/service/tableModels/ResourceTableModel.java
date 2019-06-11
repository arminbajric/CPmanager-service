package com.cpmanager.service.tableModels;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "resources")
public class ResourceTableModel implements Serializable {
    @GenericGenerator(name = "resourceIdGenerator",strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",parameters =  {
            @org.hibernate.annotations.Parameter(name = "sequence_name", value = "resourceSequence"),
            @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
            @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
    })
    @javax.persistence.Id
    @GeneratedValue(generator = "resourceIdGenerator")
    Long Id;
    @Column(name = "title")
    String title;
    @Column(name = "quantity")
    float quantity;
}
