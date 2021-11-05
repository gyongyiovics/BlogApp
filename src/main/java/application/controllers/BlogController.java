package application.controllers;

import application.dtos.BlogDTO;
import application.models.Blog;
import application.returnmodels.ReturnModel;
import application.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    //@PreAuthorize("isAuthenticated()")
    @ResponseBody
    @RequestMapping(value = "/add-new-blog",
            method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}) //only logged in
    public String postBlog(@RequestBody BlogDTO blog) {
        //ReturnModel<BlogDTO> returnText = new ReturnModel<>();
        //Blog newBlog = service.postNewBlog(blog);
        /*return ResponseEntity
                .created(URI
                        .create(String.format("/blogs")))
                .body(newBlog);
        */

        if(service.postNewBlog(blog)) {
            return "ok";
        }
        return "not ok";
    }

    /*
    @GetMapping(value = "/add-new-blog")
    public String addNewBlog() {
        if(service.newBlog()) {
            return "ok, added";
        }
        return "not ok";
    }
    */

}
