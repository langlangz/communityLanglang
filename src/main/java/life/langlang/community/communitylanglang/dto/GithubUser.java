package life.langlang.community.communitylanglang.dto;

import lombok.Data;

/**
 * @author Langlang
 * @description:
 * @date 2021-08-03 21:11
 */
@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatarUrl;

}
