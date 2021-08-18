package life.langlang.community.communitylanglang.dto;

import lombok.Data;

import java.util.List;

/**
 * @author Langlang
 * @description:
 * @date 2021-08-16 17:12
 */
@Data
public class TagDTO {
    private String categoryName;
    private List<String> tags;
}
