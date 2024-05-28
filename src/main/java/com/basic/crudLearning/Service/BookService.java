package com.basic.crudLearning.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.basic.crudLearning.Repo.Repo;
import com.basic.crudLearning.model.bookModel;

@Service
public class BookService {
    @Autowired
    private Repo bookModelRepo;

    public ResponseEntity <String> addBook(bookModel book)
    {   
        try {
            bookModel savedBook = bookModelRepo.save(book);
            // System.out.println("This is saved book -> "+savedBook.getTitle());
            String message = "Book is saved in db" + savedBook.getTitle();
            return ResponseEntity.status(HttpStatus.CREATED).body(message);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }


            
    }
    public ResponseEntity<List> getAllBook()
    {
        try {
            List<bookModel> list = bookModelRepo.findAll();
            return ResponseEntity.status(HttpStatus.OK).body(list);
        } catch (Exception e) {
            
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    public ResponseEntity<bookModel> getsingleBook(String id)
    {
       
        try {
            Optional<bookModel> bookById =  bookModelRepo.findById(id);
            if(bookById.isPresent())
            {
                return ResponseEntity.status(HttpStatus.OK).body(bookById.get());
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
           
               
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    public ResponseEntity<String> UpdateBookById(String id, bookModel book)
    {
        try {
            Optional<bookModel> bookIsPresentOrNot = bookModelRepo.findById(id);
            if(bookIsPresentOrNot.isPresent())
            {
                   bookModel existingBook  =  bookIsPresentOrNot.get();
                   existingBook .setTitle(book.getTitle());
                   existingBook .setAuthor(book.getAuthor());
                   existingBook .setIsbn(book.getIsbn());

                   bookModel updateBookDetail = bookModelRepo.save(existingBook);
                   String msg = "Book deatils is update" + updateBookDetail.getTitle();
                    return ResponseEntity.status(HttpStatus.CREATED).body(msg);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

    public ResponseEntity<String> deleteBook(String id)
    {
        try {
            Optional<bookModel> bookIsPresentOrNot = bookModelRepo.findById(id);
            if(bookIsPresentOrNot.isPresent())
            {
                bookModel existedBook = bookIsPresentOrNot.get();
                 bookModelRepo.delete(existedBook);

                return ResponseEntity.status(HttpStatus.OK).body("Book with id"+id+ "has been deleted successfully.");
            }
            else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book with ID " + id + " not found.");
            }
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while deleting the book.");
        }
    }

    
}
