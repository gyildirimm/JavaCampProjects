package com.hrms.business.abstracts;

import com.hrms.entities.concretes.Firm;

import java.util.List;

public interface FirmService {
    List<Firm> getAll();
}
