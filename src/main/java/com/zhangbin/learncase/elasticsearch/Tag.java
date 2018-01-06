package com.zhangbin.learncase.elasticsearch;

/**
 * @author zhangbin
 * @Type Tag
 * @Desc
 * @date 2018-01-03
 * @Version V1.0
 */
public class Tag {
    private Long id;
    private String name;

    public Tag(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
