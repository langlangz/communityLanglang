package life.langlang.community.communitylanglang.mapper;

import life.langlang.community.communitylanglang.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author Langlang
 * @description:
 * @date 2021-08-04 11:50
 */
@Mapper
public interface UserMapper {
    @Insert("INSERT INTO USER (name,account_id,token,gmt_create,gmt_modified) values(#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);

    @Select("SELECT * FROM USER WHERE token = #{token}")
    User findByToken(@Param("token") String token);
}
