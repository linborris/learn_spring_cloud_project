package com.atguigu;

import com.atguigu.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot04ElasticsearchApplicationTests {

    @Autowired
    ElasticsearchRepository<Book,Integer> bookRepository;
    @Test
    public void contextLoads() {
    }
    @Test
    public void test01(){
        Book book = new Book();
        book.setId(1);
        book.setName("西游记");
        book.setAuthor("吴承恩");
        bookRepository.index(book);
    }
}
