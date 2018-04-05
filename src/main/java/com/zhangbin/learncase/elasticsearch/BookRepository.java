package com.zhangbin.learncase.elasticsearch;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author zhangbin
 * @Type BookRepository
 * @Desc
 * @date 2018-01-03
 * @Version V1.0
 */
public interface BookRepository extends ElasticsearchRepository<Book, Long> {

    @Override
    Page<Book> findAll(Pageable pageable);

//    @Override
    Book findOne(Long id);
}
