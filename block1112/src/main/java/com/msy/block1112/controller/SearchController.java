package com.msy.block1112.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@EnableAutoConfiguration
@RequestMapping("/search")
public class SearchController {
        @GetMapping("/search")
        public String search(@RequestParam String keyword){
            return null;
        }
}
