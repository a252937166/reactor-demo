package com.ouyanglol.reactor.domain.user.convertor;

import com.ouyanglol.reactor.domain.user.vo.UserVo;
import org.springframework.stereotype.Component;
import com.ouyanglol.reactor.domain.user.entity.User;

/**
 * @author ouyangduning
 * @date 2020/10/26 20:55
 */
@Component
public class UserConvertor {

    public UserVo modelToVo(User user) {
        return UserVo.builder()
                .id(user.getId())
                .birthday(user.getBirthday())
                .build();
    }
}
