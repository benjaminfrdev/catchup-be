package com.project.be.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/deploy")
public class DeployController {

    @GetMapping(value = "/test")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("HI! CATCH UP BACK END IS ON");
    }
}
