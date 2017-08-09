package com.yqc.save;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 资源分类
 * Created by yangqc on 2017/8/8
 */
@Document(collection = "resource_category")
@Data
public class ResourceCategory {

    private String id;

    /**
     * 分类名称
     */
    private String categoryName;

    /**
     * 上级分类ID
     */
    private String parentId;

    /**
     * 标签
     */
    private String[] relationTags;
}
