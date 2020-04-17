package com.atguigu.elastic;

import com.alibaba.fastjson.JSONObject;
import com.atguigu.elastic.entity.Article;
import com.atguigu.elastic.entity.Book;
import com.atguigu.elastic.repository.BookRepository;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.*;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;


@SpringBootTest
class SpringBoot03ElasticApplicationTests {

    /*@Autowired
    JestClient jestClient;
    @Test
    void contextLoads() {
        Article article = new Article();
        article.setId("1");
        article.setAuthor("张三");
        article.setContent("Hello World");
        article.setTitle("好消息");
        Index build = new Index.Builder(article).index("atguigu").type("news").id("1").build();
        try {
            DocumentResult execute = jestClient.execute(build);
            System.out.println(execute.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }*/
    @Autowired
    RestHighLevelClient rhlClient;
    @Autowired
    RestClientBuilder builder;
    @Autowired
    BookRepository bookRepository;

    @Test
    void useRestClient(){
        try {
        String method = "PUT";
        String endpoint = "/atguigu/news/2";
        Article article = new Article();
        article.setId("2");
        article.setAuthor("李四");
        article.setContent("Hello World too !");
        article.setTitle("第二个好消息");
        RestClient client = builder.build();
        String jsonStr = JSONObject.toJSONString(article);
        HttpEntity entity = new NStringEntity(jsonStr, ContentType.APPLICATION_JSON);
        Request request = new Request(method,endpoint);
        request.setEntity(entity);
        Response response = client.performRequest(request);
        System.out.println(response.toString());
        System.out.println(EntityUtils.toString(response.getEntity()));
        System.out.println("新增文档结束！！！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    void searchRestClient(){
        try {
            String method = "GET";
            String endpoint = "/atguigu/news/_search";
            RestClient client = builder.build();
            Request request = new Request(method,endpoint);
            Response response = client.performRequest(request);
            System.out.println(response.toString());
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Article article = new Article();
        article.setId("2");
        article.setAuthor("李四");
        article.setContent("Hello World too !");
        article.setTitle("第二个好消息");
    }
    @Test
    void highLevelClient1(){
        Article article = new Article();
        article.setId("1");
        article.setAuthor("王五");
        article.setContent("Hello World!");
        article.setTitle("第一本书的文章");
        IndexRequest indexRequest = new IndexRequest();
        String articleStr = JSONObject.toJSONString(article);
        indexRequest.index("atguigu").type("book").id("1").source(articleStr, XContentType.JSON);
        try {
            IndexResponse response =rhlClient.index(indexRequest,RequestOptions.DEFAULT);
            System.out.println(response.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    void highLevelClient2(){
        GetRequest getRequest = new GetRequest();
        getRequest.index("atguigu").type("news").id("3");
        try {
            System.out.println(rhlClient.exists(getRequest,RequestOptions.DEFAULT));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    void highLevelClient3(){
        GetRequest getRequest = new GetRequest();
        getRequest.index("atguigu").type("news").id("3");
        try {
            String articleStr = rhlClient.get(getRequest,RequestOptions.DEFAULT).getSourceAsString();
            Article article = JSONObject.parseObject(articleStr,Article.class);
            System.out.println(article.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    void test01(){
       /* Book book = new Book();
        book.setAuthor("吴承恩");
        book.setName("西游记");
        book.setId(1);
        bookRepository.index(book);*/
        System.out.println("正常执行");
    }
}
