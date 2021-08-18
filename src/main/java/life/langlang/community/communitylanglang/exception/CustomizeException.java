package life.langlang.community.communitylanglang.exception;

/**
 * @author Langlang
 * @description:
 * @date 2021-08-10 14:53
 */
public class CustomizeException extends RuntimeException{
    private String message;
    private Integer code;



    public CustomizeException(ICustomizeErrorCode errorCode) {
        this.message = errorCode.getMessage();
        this.code = errorCode.getCode();
    }


    public String getMessage(){
        return message;
    }

    public Integer getCode(){
        return code;
    }

}
