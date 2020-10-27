package com.ouyanglol.reactor.domain.user.vo;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @author ouyangduning
 * @date 2020/10/26 20:53
 */
@Data
@Builder
public class UserVo {
    private String id;
    private String username;
    private String phone;
    private String email;
    private String name;
    private Date birthday;
}
