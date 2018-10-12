package com.lbs4.mtbackend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@RestController
public class Controller {

    private final String filePath = "/var/log/testlogs/cputemp.log";

    @RequestMapping("/upload")
    public ResponseEntity UploadFile(@RequestBody String body) {
        File textFile = new File(filePath);

        try {
            Files.write(Paths.get(filePath), (body + " Test" + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
            return ResponseEntity.ok(null);
        }
        catch (IOException e) {
            //exception handling left as an exercise for the reader
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }


//        try {
//            textFile.createNewFile();
//            FileOutputStream oFile = new FileOutputStream(textFile, true);
//            PrintWriter out = new PrintWriter(oFile);
//            out.println(file);
//            out.flush();
//            out.close();
//            return ResponseEntity.ok(null);
//        }
//        catch (Exception e){
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//        }
    }
}
