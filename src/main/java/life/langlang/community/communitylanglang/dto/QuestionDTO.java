package life.langlang.community.communitylanglang.mapper;

import life.langlang.community.communitylanglang.model.User;
import lombok.Data;

/**
 * @author Langlang
 * @description:
 * @date 2021-08-06 20:38
 */
@Data
public class QuestionDTO {
    private int id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private User user;
}
