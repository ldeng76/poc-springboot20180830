package com.bp.springboot20180830.ctrls;

import com.bp.springboot20180830.entity.Book;
import com.bp.springboot20180830.exceptions.BookNotFoundexception;
import com.bp.springboot20180830.repos.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by dzy on 2018/8/30
 */
@RestController
@RequestMapping("/api/books")
public class BookCtrl {
  @Autowired
  private BookRepository bookRepository;

  @GetMapping
  public Iterable findAll(){
    return bookRepository.findAll();
  }

  @GetMapping("/title/{bookTitle}")
  public List findByTitle(@PathVariable String bookTitle){
    return bookRepository.findByTitle(bookTitle);
  }

  @GetMapping("/{id}")
  public Optional<Book> findOne(@PathVariable Long id){
    return bookRepository.findById(id);
      //.orElseThrow(new BookNotFoundexception());
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Book create(@RequestBody Book book){
    return bookRepository.save(book);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id){
    Optional<Book> book = bookRepository.findById(id);
    if (book.isPresent()){
      bookRepository.deleteById(id);
    }
  }

  @PutMapping("{/id}")
  public Book updateBook(@RequestBody Book book,@PathVariable Long id) throws Exception {
    if (book.getId()!=id){
      throw new Exception("not match id="+id+"  book.id="+book.getId());
    }
    Optional<Book> tmpBook = bookRepository.findById(id);
    if (tmpBook.isPresent()){
      return bookRepository.save(book);
    } else {
      throw new Exception("not found id="+id);
    }
  }

}
