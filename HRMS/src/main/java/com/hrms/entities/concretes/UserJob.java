package com.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Table(name = "tbl_user_jobs")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserJob {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "job_id")
    private int jobId;
}
