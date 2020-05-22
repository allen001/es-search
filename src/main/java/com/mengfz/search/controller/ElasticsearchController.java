package com.mengfz.search.controller;

import com.mengfz.search.service.ElasticsearchService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fanzhi.meng
 * @description
 * @date 2020-05-21 18:06
 */
@AllArgsConstructor
@RestController
public class ElasticsearchController {

    private final ElasticsearchService elasticsearchService;

    @GetMapping("/search")
    public String search() {
        return elasticsearchService.toString();
    }

}
