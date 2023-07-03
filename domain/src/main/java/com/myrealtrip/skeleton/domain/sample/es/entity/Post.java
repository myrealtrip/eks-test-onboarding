package com.myrealtrip.skeleton.domain.sample.es.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

/**
 * Post
 *
 * @author sarasu
 * @since 2021.10.26
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "community")
public class Post {
    @Id
    private String id;

    private String title;
    private String content;

    @Field(type = FieldType.Nested, includeInParent = true)
    private List<MediaFile> mediaFileList;
}
