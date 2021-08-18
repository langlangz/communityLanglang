package life.langlang.community.communitylanglang.controller;

import life.langlang.community.communitylanglang.dto.CommentDTO;
import life.langlang.community.communitylanglang.dto.QuestionDTO;
import life.langlang.community.communitylanglang.enums.CommentTypeEnum;
import life.langlang.community.communitylanglang.service.CommentService;
import life.langlang.community.communitylanglang.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author Langlang
 * @description:
 * @date 2021-08-09 14:51
 */
@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id") Long id,
                           Model model){
        QuestionDTO questionDTO = questionService.getById(id);
        List<QuestionDTO> relatedQuestions = questionService.selectRelated(questionDTO);
        List<CommentDTO> comments = commentService.listByTargetId(id, CommentTypeEnum.Question);
        questionService.incViews(id);
        model.addAttribute("question", questionDTO);
        model.addAttribute("comments", comments);
        model.addAttribute("relatedQuestions", relatedQuestions);
        return "question";
    }
}
