package life.langlang.community.communitylanglang.exception;

/**
 * @author Langlang
 * @description:
 * @date 2021-08-10 15:03
 */
public enum CustomizeErrorCode implements ICustomizeErrorCode{

    QUESTION_NOT_FOUND(2001,"你找的问题不在了，要不换个试试?"),
    TARGET_PARAM_NOT_FOUND(2002,"未选中任何问题或评论进行选择"),
    NO_LOGIN(2003,"当前操作需要登录,请登录后重试"),
    SYS_ERROR(2004,"服务冒烟了, 要不你稍后再试"),
    TYPE_PARAM_WRONG(2005,"评论类型错误或不存在"),
    COMMENT_NOT_FOUND(2006, "回复的评论不存在"),
    CONTENT_IS_EMPTY(2007, "回复内容不能为空"),
    READ_NOTIFICATION_FAIL(2008,"你这是读别人信息呢"),
    NOTIFICATION_NOT_FOUND(2009,"消息莫不是不翼而飞了？"),
    FILE_UPLOAD_FAIL(2010,"文件上传失败");
    private Integer code;
    private String message;

    CustomizeErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }



}
