package com.atguigu.ipaddress.controller;

import cn.hutool.core.util.XmlUtil;
import com.alibaba.fastjson.JSONObject;
import com.github.hiwepy.ip2region.spring.boot.IP2regionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author: tony
 * @date: 2022-12-23 15:06
 * @description:
 */
@Controller
@RequestMapping("/api/v2")
public class IpAddressController {

    @Autowired
    IP2regionTemplate template;

    @RequestMapping(path = "/ip2region",method = RequestMethod.GET)
    @ResponseBody
    public String parseId(
            @RequestParam(name = "ipv4") String ipv4,
            @RequestParam(name = "output",defaultValue = "JSON") String output
    ) {
        if ("JSON".equals(output)){
            return JSONObject.toJSONString(template.getRegionAddress(ipv4));
        } else if ("XML".equals(output)){
            return XmlUtil.toStr(XmlUtil.beanToXml(template.getRegionAddress(ipv4)));
        } else {
            return JSONObject.toJSONString(template.getRegionAddress(ipv4));
        }
    }

}
