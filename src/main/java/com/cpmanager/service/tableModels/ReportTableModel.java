package com.cpmanager.service.tableModels;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="reports")
public class ReportTableModel implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 2242157082105272369L;
	@GenericGenerator(name = "reportIdGenerator",strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",parameters =  {
            @org.hibernate.annotations.Parameter(name = "sequence_name", value = "reportSequence"),
            @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
            @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
    })
    @Id
    @GeneratedValue(generator = "reportIdGenerator")
    Long Id;
    @Column(name = "solved")
    boolean solved;
    @Column(name = "area_of_problem")
    String areaofProblem;
    @Column(name = "title")
    String title;
    @Column(name = "description",length = 2000)
    String description;
    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    VehicleTableModel vehicleTableModel;

}
