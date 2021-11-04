package application.controllers;

import application.models.Blog;
import application.returnmodels.ReturnModel;
import application.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogController {
    private BlogService service;

    @Autowired
    public BlogController(BlogService service) {
        this.service = service;
    }

    @RequestMapping(value = "/blogs", method = RequestMethod.GET)
    public List<Blog> getBlogs() {
        return service.getAllBlogs();
    }

    @RequestMapping(value = "/blogs", method = RequestMethod.POST)
    public ReturnModel<String> postBlog(@RequestBody Blog blog) {
        ReturnModel<String> returnText = new ReturnModel<>();
        if(service.postNewBlog()) {
            returnText.setObject("new blog is added");
            returnText.setObject(blog.getCommentText());
        }
        returnText.setObject("something went wrong");
        return returnText;
    }
}
