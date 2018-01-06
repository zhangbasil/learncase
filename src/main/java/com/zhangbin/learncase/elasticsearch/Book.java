package com.zhangbin.learncase.elasticsearch;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author zhangbin
 * @Type Book
 * @Desc
 * @date 2018-01-03
 * @Version V1.0
 */
@Document(indexName = "basil", type = "book")
public class Book {
    @Id
    private Long id;
    @Field(type = FieldType.String)
    private String author;
    @Field(type = FieldType.String)
    private String title;
    @Field(type = FieldType.Date)
    private Date releaseDate;
    @Field(type = FieldType.Nested)
    private List<Tag> tags;

    public Book() {
    }

    public Book(Long id, String author, String title, Date releaseDate, List<Tag> tags) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.releaseDate = releaseDate;
        this.tags = tags;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
