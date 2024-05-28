package com.basic.crudLearning.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.basic.crudLearning.Service.BookService;
import com.basic.crudLearning.model.bookModel;
@RestController
@RequestMapping("/api/books")
public class BookController {
    

    @Autowired
    private BookService bookService;
    // first we add single book...
    @PostMapping
    public ResponseEntity<String> addBook(@RequestBody bookModel book)
    {
            return bookService.addBook(book);
    }
    @GetMapping
    public ResponseEntity<List> allBook()
    {
            return bookService.getAllBook();
    }

    @GetMapping("/{id}")
    public ResponseEntity<bookModel> singleBook(@PathVariable String id)
    {
        
        return bookService.getsingleBook(id);
        
    }
    @PostMapping("/{id}")
    public ResponseEntity<String> upadteBook(@RequestBody bookModel book, @PathVariable String id)
    {
        return bookService.UpdateBookById(id, book);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable String id)
    {
       return bookService.deleteBook(id);
    }

}
