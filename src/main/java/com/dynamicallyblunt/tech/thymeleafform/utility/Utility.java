package com.dynamicallyblunt.tech.thymeleafform.utility;

import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class Utility {

    public void uploadFile(String filePath) {
        File file = new File(filePath);
        if(file.exists()){

            System.out.println(file.getName());
        }

    }
}
