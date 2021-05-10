package com.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "tbl_jobs")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Job {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name = "sector_id")
    private int sectorId;

    @Column(name = "name")
    private String jobName;
}
