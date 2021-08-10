package com.wp.books.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.wp.books.models.Book;
import com.wp.books.repositories.BookRepository;
@Service
public class BookService {
    // adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    public Book updateBook(Long id, String title, String desc, String lang, int numOfPages) {
    	
    	 Optional<Book> optionalBook = bookRepository.findById(id);
         if(optionalBook.isPresent()) {
             Book b = optionalBook.get();
             b.setTitle(title);
             b.setDescription(desc);
             b.setLanguage(lang);
             b.setNumberOfPages(numOfPages);
             return bookRepository.save(b);
         } else {
             return null;
         }
         
    }
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
		
	}
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
}