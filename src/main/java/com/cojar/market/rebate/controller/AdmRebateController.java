package com.cojar.market.rebate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("adm/rebate")
public class AdmRebateController {
    @GetMapping("/makeData")
    public String showMakeData() {
        return "adm/rebate/makeData";
    }
}
