package com.dynamicallyblunt.tech.thymeleafform.beans;

import lombok.Data;

@Data
public class Script {
    private String name;
    private String validateMethod;
    private String evaluateMethod;
    private String remediateMethod;
}
