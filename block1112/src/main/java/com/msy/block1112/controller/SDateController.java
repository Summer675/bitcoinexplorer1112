package com.msy.block1112.controller;

import com.msy.block1112.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sdate")
public class SDateController {
    @Autowired
    private BlockService blockService;

    @PostMapping("/fullImport")
    public void fullImport(@RequestParam(required = false, defaultValue = "000000000933ea01ad0ee984209779baaec3ced90fa3f408719526f8d77f4943") String blockhash){
        blockService.sBlocks(blockhash);
    }
}
