package com.wfj.learn.apiserver.entity;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private Integer id;
    private String userName;
    private String password;
    private String mobile;

}
