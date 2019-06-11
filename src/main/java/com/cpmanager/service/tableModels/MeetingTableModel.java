package com.cpmanager.service.tableModels;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "meeting")
public class MeetingTableModel implements Serializable {
    @GenericGenerator(name = "meetingIdGenerator",strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",parameters =  {
            @org.hibernate.annotations.Parameter(name = "sequence_name", value = "meetingSequence"),
            @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
            @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
    })
    @Id
    @GeneratedValue(generator = "meetingIdGenerator")
    Long Id;
    @Column(name = "title")
    String title;
    @Column(name = "description",length = 2000)
    String description;
    @Column(name = "office")
    int office;
    @ManyToOne
    @JoinColumn(name = "user_id")
   MeetingTableModel meetingTableModel;
}
