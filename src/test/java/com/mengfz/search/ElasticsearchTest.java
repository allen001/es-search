package com.mengfz.search;

import com.mengfz.search.pojo.Product;
import com.mengfz.search.service.ProductRepository;
import org.elasticsearch.common.StopWatch;
import org.elasticsearch.common.unit.TimeValue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fanzhi.meng
 * @description
 * @date 2020-05-22 12:21
 */
@SpringBootTest
public class ElasticsearchTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void add() {
        StopWatch sw = new StopWatch();
        sw.start();
        List<Product> l = new ArrayList<>(10000);
        for (int i = 0; i < 10000; i++) {
            l.add(new Product().setId(i + 1)
                    .setTitle("Java-麦思加")
                    .setPrice(13.2F * (i + 1))
                    .setDescription("java-麦思加教育-测试")
                    .setPic("https://img10.360buyimg.com/n7/jfs/t1/26339/8/10661/124305/5c8af829E4470835f/99742c91174d3d7a.jpg"));
            System.out.println("product:" + i);
        }
        productRepository.saveAll(l);
        sw.stop();
        System.out.println("totalTime:" + sw.totalTime().getSeconds() + "秒");
    }

    @Test
    void dPro() {
        productRepository.deleteById(1);
        System.out.println("success");
    }

    @Test
    void dAllPro() {
        StopWatch sw = new StopWatch();
        sw.start();
        productRepository.deleteAll();
        sw.stop();
        TimeValue timeValue = sw.totalTime();
        System.out.println("success:" + timeValue.getSeconds());
    }
}
