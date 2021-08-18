package life.langlang.community.communitylanglang.advice;

import com.alibaba.fastjson.JSON;
import life.langlang.community.communitylanglang.dto.ResultDTO;
import life.langlang.community.communitylanglang.exception.CustomizeErrorCode;
import life.langlang.community.communitylanglang.exception.CustomizeException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Langlang
 * @description:
 * @date 2021-08-10 14:03
 */
@ControllerAdvice
public class CustomizeExceptionHandler {

    @ExceptionHandler(Exception.class)
    public Object handleControllerException(Throwable ex, Model model, HttpServletRequest request, HttpServletResponse response) {
        String contentType = request.getContentType();
        if("application/json".equals(contentType)){
            ResultDTO resultDTO = null;
            //当异常是我们知道的异常时
            if(ex instanceof CustomizeException){
                resultDTO= ResultDTO.errorOf((CustomizeException) ex);
            } else {
                //当异常不是我们知道的异常时,统一抛出异常
                resultDTO = ResultDTO.errorOf((CustomizeErrorCode.SYS_ERROR));
            }

            try {
                response.setContentType("application/json");
                response.setStatus(200);
                response.setCharacterEncoding("utf-8");
                PrintWriter writer = response.getWriter();
                writer.write(JSON.toJSONString(resultDTO));
                writer.close();
            } catch (IOException ioe) {
            }
            return null;
        }else {
            if(ex instanceof CustomizeException){
                model.addAttribute("message", ex.getMessage());
            }else {
                model.addAttribute("message", CustomizeErrorCode.SYS_ERROR.getMessage());
            }
            return new ModelAndView("error");
        }
    }


}
