package com.liukai.myspringboot.repository;

import com.liukai.myspringboot.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author liukai
 */
public interface ReadingListRepository extends JpaRepository<Book, Long> {

  /**
   * 查询
   *
   * @param reader
   * @return
   */
  List<Book> findByReader(String reader);
}
