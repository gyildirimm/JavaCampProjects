package com.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Table(name = "tbl_firm_jobs")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(
        {"hibernateLazyInitializer",
        "handler",
        "job",
        "province",
        "firm"})
public class FirmJob {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name = "explanation")
    private String explanation;

    @Column(name = "price_min")
    private double priceMin;

    @Column(name = "price_max")
    private double priceMax;

    @Column(name = "jobs_count")
    private int jobCount;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "is_active")
    private boolean isActive;

    @ManyToOne()
    @JoinColumn(name = "job_id")
    private Job job;

    @ManyToOne()
    @JoinColumn(name = "province_id")
    private Province province;

    @ManyToOne()
    @JoinColumn(name = "firm_id")
    private Firm firm;
}
