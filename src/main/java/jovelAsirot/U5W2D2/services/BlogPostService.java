package jovelAsirot.U5W2D2.services;

import jovelAsirot.U5W2D2.entities.BlogPost;
import jovelAsirot.U5W2D2.enums.Category;
import jovelAsirot.U5W2D2.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class BlogPostService {

    private List<BlogPost> blogPostList = new ArrayList<>();

    public List<BlogPost> getBlogPostList() {
        return blogPostList;
    }

    public BlogPost saveBloPost(BlogPost body) {
        Random rdm = new Random();
        Category[] categories = Category.values();

        body.setId(rdm.nextLong(20L, 100000L));
        body.setCategory(categories[rdm.nextInt(categories.length)]);

        this.blogPostList.add(body);
        return body;
    }

    public BlogPost findById(Long id) {
        BlogPost blogFound = null;
        for (BlogPost post : this.blogPostList) {
            if (post.getId() == id) blogFound = post;
        }
        if (blogFound == null) throw new NotFoundException(id);
        else return blogFound;
    }

    public BlogPost updateById(Long id, BlogPost updatedPost) {
        BlogPost blogFound = null;
        for (BlogPost post : this.blogPostList) {
            if (post.getId() == id) {
                blogFound = post;

                blogFound.setCategory(updatedPost.getCategory());
                blogFound.setCover(updatedPost.getCover());
                blogFound.setContent(updatedPost.getContent());
                blogFound.setReadingTime(updatedPost.getReadingTime());
            }
        }
        if (blogFound == null) throw new NotFoundException(id);
        else return blogFound;
    }

    public void deleteById(Long id) {
        Iterator<BlogPost> blogPostIterator = this.blogPostList.iterator();
        boolean postFound = false;

        while (blogPostIterator.hasNext()) {
            BlogPost currentPost = blogPostIterator.next();
            if (currentPost.getId() == id) {
                blogPostIterator.remove();
                postFound = true;
                break;
            }
        }
        if (!postFound) throw new NotFoundException(id);
    }
}
