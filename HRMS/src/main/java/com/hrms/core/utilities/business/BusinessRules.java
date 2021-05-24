package com.hrms.core.utilities.business;

import com.hrms.core.utilities.results.Result;

public class BusinessRules {

    public static Result Run(Result... logics) {
        for (Result r: logics) {
            if(!r.isSuccess()) {
                return r;
            }
        }

        return null;
    }

}
