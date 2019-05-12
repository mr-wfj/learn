package com.wfj.learn.apiserver.base.order;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {

    private String number;

    private String type;

    private double amount;

    private String description;

}
