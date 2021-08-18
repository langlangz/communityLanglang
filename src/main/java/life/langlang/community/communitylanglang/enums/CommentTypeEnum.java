package life.langlang.community.communitylanglang.enums;

/**
 * @author Langlang
 * @description:
 * @date 2021-08-11 16:12
 */
public enum CommentTypeEnum {
    Question(1),
    COMMENT(2);
    private Integer type;

    CommentTypeEnum(Integer type) {
        this.type = type;
    }

    public static boolean isExist(Integer type) {
        for (CommentTypeEnum value : CommentTypeEnum.values()) {
            if(value.getType() == type){
                return true;
            }
        }
        return false;
    }

    public Integer getType() {
        return type;
    }
}
