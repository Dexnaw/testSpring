package be.heh.test_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Configuration
@ComponentScan("be.heh")
public class HomeController {

    private IBookRepository bookRepository;



    @Autowired
    public HomeController (IBookRepository bookRepo) {
        this.bookRepository = bookRepo;
    }

    @RequestMapping(value="/{reader}", method= RequestMethod.GET)
    public String readersBooks(
            @PathVariable("reader") String reader, Model model) {
        List listBooks = bookRepository.findByReader(reader);
        if (listBooks != null){
            model.addAttribute("book", listBooks);
        }
        return "readingList"; //vue
    }

    @RequestMapping(value="/{reader}", method= RequestMethod.POST)
    public String addToBookList(
            @PathVariable("reader") String reader, Book book) {
        book.setReader(reader);
        bookRepository.save(book);
        return "redirect:/{reader}";
    }

}