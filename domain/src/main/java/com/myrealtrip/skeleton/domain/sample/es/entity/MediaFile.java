package com.myrealtrip.skeleton.domain.sample.es.entity;

import com.myrealtrip.skeleton.core.type.MediaFileType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * MediaFile
 *
 * @author sarasu
 * @since 2021.10.26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MediaFile implements Serializable {
    private MediaFileType mediaFileType;
    private String fileName;
    private int fileOrder;
}
