package life.langlang.community.communitylanglang.dto;

import life.langlang.community.communitylanglang.model.User;
import lombok.Data;

/**
 * @author Langlang
 * @description:
 * @date 2021-08-13 11:37
 */
@Data
public class CommentDTO {
    private Long id;
    private Long parentId;
    private Integer type;
    private Long commentator;
    private Long gmtCreate;
    private Long gmtModified;
    private Long likeCount;
    private Integer commentCount;
    private String content;
    private User user;

}
