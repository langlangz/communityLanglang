package life.langlang.community.communitylanglang.dto;

import lombok.Data;

/**
 * @author Langlang
 * @description:
 * @date 2021-08-11 14:44
 */
@Data
public class CommentCreateDTO {
    private Long parentId;
    private String content;
    private Integer type;
}
