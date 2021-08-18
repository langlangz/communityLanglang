package life.langlang.community.communitylanglang.mapper;

import life.langlang.community.communitylanglang.model.Question;
import org.apache.ibatis.annotations.Param;

public interface CommentExtMapper {

    int incView(@Param("record") Question record);

    int incCommentCount(@Param(("record")) Question question);


}