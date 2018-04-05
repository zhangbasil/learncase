package com.zhangbin.learncase.lombok;

import java.util.List;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * @author zhangbin
 * @Type Project
 * @Desc
 * @date 2018-04-04
 * @Version V1.0
 */
//@Setter
//@Getter
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(exclude = {"projects", "project"})
public class Project {
    Long id;
    String name;
    List<Project> projects;
    Project project;

    public Project(Long id) {
        this.id = id;
    }
    public Project() {
        this.id = id;
    }

}
