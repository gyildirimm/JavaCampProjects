package com.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Table(name = "tbl_firms")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Firm {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "name")
    private String firmName;

    @Column(name = "web_site")
    private Date birthDate;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "phone", unique = true)
    private String phone;


    @Column(name = "is_approval")
    private boolean isApproval;

    @Column(name = "is_approval_email")
    private boolean isApprovalEmail;
}
