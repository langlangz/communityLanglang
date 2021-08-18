package life.langlang.community.communitylanglang.enums;

/**
 * @author Langlang
 * @description:
 * @date 2021-08-17 9:30
 */
public enum NotificationEnum {
    REPLY_QUESTION(1, "回复了问题"),
    REPLY_COMMENT(2, "回复了评论");
    private int type;
    private String name;

    NotificationEnum(int status, String name){
        this.type = status;
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
