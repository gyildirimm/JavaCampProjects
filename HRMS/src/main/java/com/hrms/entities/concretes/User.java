package com.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Id;
import java.util.Date;

@Table(name = "tbl_users")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "UUID")
    private String Id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "email")
    private String email;

    @Column(name = "tc")
    private String tc;

    @Column(name = "password")
    private String password;

    @Column(name = "is_approval")
    private boolean isApproval;

    @Column(name = "is_approval_email")
    private boolean isApprovalEmail;
}
