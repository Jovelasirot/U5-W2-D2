package jovelAsirot.U5W2D2.controllers;

import jovelAsirot.U5W2D2.entities.BlogAuthor;
import jovelAsirot.U5W2D2.services.BlogAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog/author")
public class BlogAuthorController {
    @Autowired
    private BlogAuthorService blogAuthorService;

    @GetMapping
    private List<BlogAuthor> getAllAuthor() {
        return this.blogAuthorService.getBlogAuthorList();
    }

    @GetMapping("{authorId}")
    private BlogAuthor getSingleAuthor(@PathVariable long authorId) {
        return this.blogAuthorService.findById(authorId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private BlogAuthor saveAuthor(@RequestBody BlogAuthor body) {
        return this.blogAuthorService.saveAuthor(body);
    }

    @PutMapping("{blogId}")
    private BlogAuthor updateAuthor(@PathVariable long blogId, @RequestBody BlogAuthor newBody) {
        return this.blogAuthorService.updateById(blogId, newBody);
    }

    @DeleteMapping("{blogId}")
    private void deleteAuthor(@PathVariable long blogId) {
        this.blogAuthorService.deleteById(blogId);
    }
}
