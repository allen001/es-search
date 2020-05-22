package com.mengfz.search.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mengfz.search.pojo.Product;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.util.Objects;

/**
 * @author fanzhi.meng
 * @description ES服务器操作核心工具类
 * @date 2020-05-21 17:05
 */
@Service
public class ElasticsearchService {

    /**
     * 创建ES客户端，链接Docker中ES集群
     *
     * @return
     */
    public TransportClient getTransportClient() {
        try {
            // 创建一个Settings
            Settings settings = Settings.builder().put("cluster.name", "elasticsearch-cluster").build();
            // 创建客户端对象
            TransportClient transportClient = new PreBuiltTransportClient(settings);
            transportClient.addTransportAddress(new TransportAddress(InetAddress.getByName("39.100.59.218"), 9300));
            transportClient.addTransportAddress(new TransportAddress(InetAddress.getByName("39.100.59.218"), 9301));
            transportClient.addTransportAddress(new TransportAddress(InetAddress.getByName("39.100.59.218"), 9302));

            return transportClient;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 创建索引数据
     */
    public void createIndex() {
        TransportClient transportClient = null;
        try {
            // 获取服务器链接
            transportClient = getTransportClient();
            // 创建文件
            Product product = new Product();
            product.setId(2);
            product.setTitle("java架构师之路2");
            product.setPrice(99.82F);
            product.setPic("https://img10.360buyimg.com/n7/jfs/t1/26339/8/10661/124305/5c8af829E4470835f/99742c91174d3d7a.jpg");
            product.setDescription("历经15次技术架构升级2");

            // 转换json
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(product);

            // 把文档数据添加到ES数据库中
            transportClient.prepareIndex("es_book", "product", product.getId() + "")
                    .setSource(jsonString, XContentType.JSON)
                    .get();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(transportClient)) {
                transportClient.close();
            }
            System.out.println("索引创建成功");
        }

    }
}
