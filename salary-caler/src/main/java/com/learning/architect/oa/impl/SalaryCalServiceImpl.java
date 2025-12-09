package com.learning.architect.oa.impl;

import com.learning.architect.oa.SalaryCalService;

/**
 * @author HartLi
 * @version 1.0.0
 * @desc TODO
 * @date 2025-12-09 17:55
 */
public class SalaryCalServiceImpl implements SalaryCalService {
    @Override
    public Double cal(Double salary) {
        return salary * 1.5;
    }
}
