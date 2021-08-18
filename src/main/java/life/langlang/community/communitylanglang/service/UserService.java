package life.langlang.community.communitylanglang.service;

import life.langlang.community.communitylanglang.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Langlang
 * @description:
 * @date 2021-08-09 16:41
 */
@Service
public class UserServiece {
    @Autowired
    private UserMapper userMapper;

}
