package life.langlang.community.communitylanglang.mapper;

import life.langlang.community.communitylanglang.model.Question;

import java.util.List;

public interface QuestionExtMapper {

    int incView(Question question);

    int incCommentCount( Question question);

    List<Question> selectRelated(Question question);
}