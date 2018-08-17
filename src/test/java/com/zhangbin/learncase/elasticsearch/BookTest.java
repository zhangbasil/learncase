package com.zhangbin.learncase.elasticsearch;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhangbin
 * @Type BookTest
 * @Desc
 * @date 2018-01-03
 * @Version V1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookTest {
    @Resource
    private BookRepository bookRepository;



    @Test
    public void saveTest() {
    }

    @Test
    public void findOneTest() {

        String query = "入门到放弃";
        QueryStringQueryBuilder stringQueryBuilder = new QueryStringQueryBuilder(query);

        Pageable defaultPage = SearchQuery.DEFAULT_PAGE;

        Page<Book> search = bookRepository.search(stringQueryBuilder, defaultPage);
        System.out.println("search = " + search);
    }

    @Test
    public void findAllTest() {
        Iterable<Book> all = bookRepository.findAll();
        System.out.println("all = " + all);
    }


    private List<Book> getBooks() {
        List<Tag> tags = new ArrayList<>();
        tags.add(new Tag(1L, "spring"));
        tags.add(new Tag(2L, "spring boot"));
        tags.add(new Tag(3L, "张斌"));
        Book book1 = new Book(101L, "TOM zhangbin", "elasticsearch 从入门到放弃", new Date(), tags);
        Book book2 = new Book(102L, "张斌", "Linux 从入门到放弃", new Date(), tags);
        Book book3 = new Book(103L, "盖伦", "Tomcat 从入门到放弃", new Date(), null);
        Book book4 = new Book(104L, "TOM，Jetty", "Jet统一 从入门到放弃", new Date(), tags);
        Book book5 = new Book(105L, "张三丰", "  sadfa 从入门到放弃", new Date(), tags);
        Book book6 = new Book(106L, "张三四", "阿斯蒂芬 从入门到放弃", new Date(), null);
        Book book7 = new Book(107L, "tzhang", "  sdf 从入门到放弃", new Date(), null);

        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        books.add(book6);
        books.add(book7);

        return books;

    }


}
