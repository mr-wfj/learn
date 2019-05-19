package com.wfj.learn.gateway.utils;

import lombok.Builder;
import lombok.Data;

/**
 * @author : WFJ
 */
@Data
@Builder
public class Role {
    private Long id;
    private String name;
    private String code;
}
