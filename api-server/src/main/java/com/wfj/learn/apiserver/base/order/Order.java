package com.wfj.learn.apiserver.base.order;

import lombok.Data;

@Data
public class Order {

    private String number;

    private String type;

    private double amount;

    private String description;

}
