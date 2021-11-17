package com.dynamicallyblunt.tech.thymeleafform.beans;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class Controls {

    private String name;
    private String version;
    private String guid;
    private Description description;
    private String returnType;
    private String platformType;
    private SupportedPlatforms[] platformSupported;
    private String[] imports;
    private List<Script> scripts;
    private MultipartFile evaluatePyFile;
    private MultipartFile remediatePyFile;
    private List<EvaluateArgument> evaluateArguments;
    private List<RemediateArgument> remediateArguments;

}
