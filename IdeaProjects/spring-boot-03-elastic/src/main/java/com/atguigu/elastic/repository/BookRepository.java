package com.atguigu.elastic.repository;

import com.atguigu.elastic.entity.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface BookRepository extends ElasticsearchRepository<Book,Integer> {
}
