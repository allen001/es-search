package com.mengfz.search.service;

import com.mengfz.search.pojo.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author fanzhi.meng
 * @description
 * @date 2020-05-22 11:17
 */
public interface ProductRepository extends ElasticsearchRepository<Product, Integer> {


}
