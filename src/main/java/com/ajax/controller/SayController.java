package com.ajax.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ajax Huang
 * @create 2021-10-23-11:18
 */
@RestController
public class SayController {

    @RequestMapping(value = "/sayhi")
    public String sayhi(){
        System.out.println("keeps getting better hi");
        return "keeps getting better hi";
    }
}
