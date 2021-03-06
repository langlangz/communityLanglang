package life.langlang.community.communitylanglang.controller;

import life.langlang.community.communitylanglang.cache.TagCache;
import life.langlang.community.communitylanglang.dto.QuestionDTO;
import life.langlang.community.communitylanglang.mapper.QuestionMapper;
import life.langlang.community.communitylanglang.model.Question;
import life.langlang.community.communitylanglang.model.User;
import life.langlang.community.communitylanglang.service.QuestionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Langlang
 * @description:
 * @date 2021-08-05 17:21
 */
@Controller
public class PublishController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/publish/{id}")
    public String edit(@PathVariable(name = "id") Long id,
                       Model model){
        QuestionDTO question = questionService.getById(id);
        model.addAttribute("title",question.getTitle());
        model.addAttribute("description",question.getDescription());
        model.addAttribute("tag",question.getTag());
        model.addAttribute("id",question.getId());
        model.addAttribute("tags", TagCache.get());

        return "publish";
    }
    @GetMapping("/publish")
    public String publish(Model model){
        model.addAttribute("tags", TagCache.get());
        return "publish";
    }
    @PostMapping("/publish")
    public String doPublish(
            @RequestParam(value = "title",required = false) String title,
            @RequestParam(value = "description",required = false) String description,
            @RequestParam(value = "tag",required = false) String tag,
            @RequestParam(value = "id",required = false) Long id,
            HttpServletRequest request,
            Model model){
        model.addAttribute("title",title);
        model.addAttribute("description",description);
        model.addAttribute("tag",tag);
        model.addAttribute("tags", TagCache.get());


        if ((title == null || title == "")){
            model.addAttribute("error","??????????????????");
            return "publish";
        }
        if ((description == null || description == "")){
            model.addAttribute("error","????????????????????????");
            return "publish";
        }
        if ((tag == null || tag == "")){
            model.addAttribute("error","??????????????????");
            return "publish";
        }

        String invalid = TagCache.filterinValid(tag);
        if(StringUtils.isNotBlank(invalid)){
            model.addAttribute("error","??????????????????:" +invalid);
            return "publish";
        }

        User user = (User) request.getSession().getAttribute("user");
        if(user == null){
            model.addAttribute("error","???????????????");
            return "publish";
        }
        Question question = new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setCreator(user.getId());
        question.setId(id);
        questionService.createOrUpdate(question);
        return "redirect:/";


    }
}
