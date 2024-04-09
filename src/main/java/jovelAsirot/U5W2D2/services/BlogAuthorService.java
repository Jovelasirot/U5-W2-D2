package jovelAsirot.U5W2D2.services;

import jovelAsirot.U5W2D2.entities.BlogAuthor;
import jovelAsirot.U5W2D2.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class BlogAuthorService {

    private List<BlogAuthor> blogAuthorList = new ArrayList<>();

    public List<BlogAuthor> getBlogAuthorList() {
        return blogAuthorList;
    }

    public BlogAuthor saveAuthor(BlogAuthor body) {
        Random rdm = new Random();
        LocalDate today = LocalDate.now();
        String authorEmail = body.getName() + body.getSurname() + "@gmail.com";
        String authorAvatar = "https://ui-avatars.com/api/?name=" + body.getName() + "+" + body.getSurname();

        body.setId(rdm.nextLong(20L, 100000L));
        body.setBirthDate(today.minusYears(rdm.nextInt(11, 20)));
        body.setEmail(authorEmail);
        body.setAvatar(authorAvatar);
        this.blogAuthorList.add(body);
        return body;
    }

    public BlogAuthor findById(Long id) {
        BlogAuthor authorFound = null;
        for (BlogAuthor author : this.blogAuthorList) {
            if (author.getId() == id) authorFound = author;
        }
        if (authorFound == null) throw new NotFoundException(id);
        else return authorFound;
    }

    public BlogAuthor updateById(Long id, BlogAuthor updatedAuthor) {
        BlogAuthor authorFound = null;
        for (BlogAuthor author : this.blogAuthorList) {
            if (author.getId() == id) {
                authorFound = author;
                Random rdm = new Random();

                LocalDate today = LocalDate.now();
                String authorEmail = updatedAuthor.getName() + updatedAuthor.getSurname() + "@gmail.com";
                String authorAvatar = "https://ui-avatars.com/api/?name=" + updatedAuthor.getName() + "+" + updatedAuthor.getSurname();

                authorFound.setName(updatedAuthor.getName());
                authorFound.setSurname(updatedAuthor.getSurname());
                authorFound.setEmail(authorEmail);
                authorFound.setAvatar(authorAvatar);
                authorFound.setBirthDate(today.minusYears(rdm.nextInt(11, 20)));
            }
        }
        if (authorFound == null) throw new NotFoundException(id);
        else return authorFound;
    }

    public void deleteById(Long id) {
        Iterator<BlogAuthor> blogAuthorIterator = this.blogAuthorList.iterator();
        boolean authorFound = false;

        while (blogAuthorIterator.hasNext()) {
            BlogAuthor currentAuthor = blogAuthorIterator.next();
            if (currentAuthor.getId() == id) {
                blogAuthorIterator.remove();
                authorFound = true;
                break;
            }
        }
        if (!authorFound) throw new NotFoundException(id);
    }
}
