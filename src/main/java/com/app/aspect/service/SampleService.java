package com.app.aspect.service;

import com.app.aspect.aspect.annotation.LogStatus;
import com.app.aspect.aspect.annotation.ZeroDivision;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static java.lang.Integer.*;

@Service
@Slf4j
public class SampleService {

    @LogStatus
    public Integer doAdd(String str1, String str2) {
        log.info("핵심로직");
        return parseInt(str1) + parseInt(str2);
    }

    @ZeroDivision
    public Double doSub(String str1, String str2) {
        return Double.parseDouble(str1) / Double.parseDouble(str2);
    }
}
