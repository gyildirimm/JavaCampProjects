package com.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tbl_province")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Province {
    @Id
    @Column(name = "id")
    private int Id;

    @Column( name = "name")
    private String name;
}
