package com.mengfz.search.pojo;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * @author fanzhi.meng
 * @description
 * @date 2020-05-21 17:03
 */
@Data
@Accessors(chain = true)
@Document(indexName = "es_book", type = "product")
public class Product implements Serializable {

    /**
     * 产品Id
     */
    @Id
    private Integer id;
    /**
     * 产品标题
     */
    @Field(type = FieldType.Keyword)
    private String title;
    /**
     * 产品价格
     */
    @Field(type = FieldType.Float)
    private Float price;
    /**
     * 图片
     */
    @Field(type = FieldType.Keyword)
    private String pic;
    /**
     * 描述
     */
    @Field(type = FieldType.Keyword)
    private String description;
}
