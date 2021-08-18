package life.langlang.community.communitylanglang.dto;

import life.langlang.community.communitylanglang.model.User;
import lombok.Data;

/**
 * @author Langlang
 * @description:
 * @date 2021-08-17 9:58
 */
@Data
public class NotificationDTO {
    private Long id;
    private Long gmtCreate;
    private Integer status;
    private String notifierName;
    private String outerTitle;
    private Long outerid;
    private String typeName;
    private Integer type;
}
