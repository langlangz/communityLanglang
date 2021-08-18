package life.langlang.community.communitylanglang.enums;

/**
 * @author Langlang
 * @description:
 * @date 2021-08-17 9:37
 */
public enum NotificationStatusEnum {
    UNREAD(0),READ(1);
    private int status;

    private NotificationStatusEnum(int status){
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
