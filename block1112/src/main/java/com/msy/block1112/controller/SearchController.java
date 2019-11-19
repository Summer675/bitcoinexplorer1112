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


            if (keyword.matches("-?\\d+")){
                return "block detail url";
            }

            if (keyword.length() < 64){
                return "address info url";
            }

            if (keyword.startsWith("00000")){
                return "block detail url";
            }else {
                return "tx detail url";
            }

        }


}
