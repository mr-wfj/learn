package com.wfj.learn.gateway.utils;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author : WFJ
 */
@Data
public class UserDetail {
    
    private long id;
    private String username;
    private String password;
    private List<Role> roles;
    private Date lastPasswordResetDate;


}
