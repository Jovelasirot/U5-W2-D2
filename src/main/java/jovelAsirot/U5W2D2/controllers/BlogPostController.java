package jovelAsirot.U5W2D2.controllers;

import jovelAsirot.U5W2D2.entities.BlogPost;
import jovelAsirot.U5W2D2.services.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog/post")
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    @GetMapping
    private List<BlogPost> getAllBlogPost() {
        return this.blogPostService.getBlogPostList();
    }

    @GetMapping("{blogId}")
    private BlogPost getSingleBlogPost(@PathVariable long blogId) {
        return this.blogPostService.findById(blogId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private BlogPost saveBlogPost(@RequestBody BlogPost body) {
        return this.blogPostService.saveBloPost(body);
    }

    @PutMapping("{blogId}")
    private BlogPost updateBlogPost(@PathVariable long blogId, @RequestBody BlogPost newBody) {
        return this.blogPostService.updateById(blogId, newBody);
    }

    @DeleteMapping("{blogId}")
    private void deleteBlogPost(@PathVariable long blogId) {
        this.blogPostService.deleteById(blogId);
    }
}
