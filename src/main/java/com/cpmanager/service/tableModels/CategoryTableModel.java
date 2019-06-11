package com.cpmanager.service.tableModels;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name = "categories")
public class CategoryTableModel implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7885779855081468647L;
	@GenericGenerator(name = "categoryIdGenerator",strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",parameters =  {
            @org.hibernate.annotations.Parameter(name = "sequence_name", value = "categorySequence"),
            @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
            @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
    })
    @javax.persistence.Id
    @GeneratedValue(generator = "categoryIdGenerator")
    Long Id;
    @Column(name = "name")
    String name;
    @OneToMany(mappedBy = "categoryTableModel")
    Set<VehicleTableModel> vehicleTableModels=new TreeSet<>();
}
