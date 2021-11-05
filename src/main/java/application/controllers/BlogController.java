package application.controllers;

import application.dtos.BlogDTO;
import application.models.Blog;
import application.returnmodels.ReturnModel;
import application.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @RequestMapping(value = "/blogs", method = RequestMethod.GET) //only logged in
    public List<Blog> getBlogs() {
        return service.getAllBlogs();
    }

    /*@RequestMapping(value = "/add_blogs", method = RequestMethod.GET)
    public String addBlogs() {
        if(service.postNewBlog()) {
            return "ok";
        }
        return "nem ok";
    }*/

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/blogs", method = RequestMethod.POST) //only logged in
    public ReturnModel<String> postBlog(@RequestBody BlogDTO blogDTO) {
        ReturnModel<String> returnText = new ReturnModel<>();

        if(service.postNewBlog(blogDTO)) {
            returnText.setObject("new blog is added");
        }

        returnText.setObject("something went wrong");
        return returnText;
    }

}
