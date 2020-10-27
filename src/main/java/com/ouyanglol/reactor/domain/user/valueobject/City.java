package com.ouyanglol.reactor.domain.user.valueobject;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author ouyangduning
 * @date 2020/10/26 15:01
 */
@Data
@Builder
@Document
public class City {
    @Id
    private String id;
    private String provinceId;
    private String cityName;
    private String description;
}
