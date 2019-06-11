package com.cpmanager.service.tableModels;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;


@Entity
@Table(name = "requests")
public class RequestTableModel implements Serializable {
    @GenericGenerator(name = "requestIdGenerator",strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",parameters =  {
            @org.hibernate.annotations.Parameter(name = "sequence_name", value = "requestSequence"),
            @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
            @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
    })
    @javax.persistence.Id
    @GeneratedValue(generator = "requestIdGenerator")
    Long Id;
    @Column(name="title")
    String title;
    @Column(name = "solved")
    boolean solved;
    @Column(name = "description",length = 3000)
    String description;
    @Column(name = "deadline")
    Date deadline;
    @ManyToOne
    @JoinColumn(name = "user_id")
    UserTableModel userTableModel;
}
