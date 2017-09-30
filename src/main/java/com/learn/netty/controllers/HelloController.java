package com.learn.netty.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Author : mastXu
 * Description : saying something
 * Date : 2017/9/28.
 * Modify :
 */
@RestController
@RequestMapping("/api")
public class HelloController {
    @Autowired
    ObjectMapper mapper;

    @GetMapping("/hello/{name}")
    public Object hello(@PathVariable String name) {
        ObjectNode node = mapper.createObjectNode();
        node.put("code", HttpStatus.OK.value());
        node.put("message", "hello "+ name);

        return node;
    }
}
