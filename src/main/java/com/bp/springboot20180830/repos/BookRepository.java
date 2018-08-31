package com.bp.springboot20180830.repos;

import com.bp.springboot20180830.entity.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by dzy on 2018/8/30
 */
public interface BookRepository extends CrudRepository<Book,Long> {
  List<Book> findByTitle(String title);
}
