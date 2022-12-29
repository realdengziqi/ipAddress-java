package com.atguigu.ipaddress.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: tony
 * @date: 2022-12-29 7:23
 * @description:
 */
@Controller
public class DocController {

    @GetMapping("/doc")
    public String doc() {
        return "doc";
    }
}
