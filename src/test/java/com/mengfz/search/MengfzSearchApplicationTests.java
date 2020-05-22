package com.mengfz.search;

import com.mengfz.search.service.ElasticsearchService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MengfzSearchApplicationTests {

    @Autowired
    private ElasticsearchService elasticsearchService;

    @Test
    void client() {
        System.out.println(elasticsearchService.getTransportClient());
    }

    @Test
    void createIndex() {
        elasticsearchService.createIndex();
    }
}
