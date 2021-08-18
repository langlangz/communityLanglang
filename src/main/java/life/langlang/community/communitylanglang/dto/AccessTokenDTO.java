package life.langlang.community.communitylanglang.dto;

import lombok.Data;

/**
 * @author Langlang
 * @description:
 * @date 2021-08-03 20:44
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
