package com.mrfang.yunhome.domain;

import lombok.Data;

@Data
public class SignContract {

    private long id;
    private long userId;
    private long tenantId;
    private long homeId;
    private long contractId;
    private String startTime;
    private String endTime;
    private long status;

}
