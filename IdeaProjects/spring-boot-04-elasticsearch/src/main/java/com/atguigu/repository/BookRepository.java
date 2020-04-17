package com.atguigu.repository;

import com.atguigu.entity.Book;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

@Document(indexName = "library",type = "book")
public interface BookRepository extends ElasticsearchRepository<Book,Integer> {

}
