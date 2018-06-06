package com.liukai.myspringboot.controller;

import com.liukai.myspringboot.model.Book;
import com.liukai.myspringboot.repository.ReadingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author liukai
 */
@Controller
@RequestMapping("/")
public class ReadingListController {

  private ReadingListRepository readingListRepository;

  @Autowired
  public ReadingListController(ReadingListRepository readingListRepository) {
    this.readingListRepository = readingListRepository;
  }

  /**
   * 获取书列表
   *
   * @param reader
   * @param model
   * @return
   */
  @RequestMapping(value = "/{reader}", method = RequestMethod.GET)
  public String readersBooks(@PathVariable("reader") String reader, Model model) {
    List<Book> readingList = readingListRepository.findByReader(reader);
    if (readingList != null) {
      model.addAttribute("books", readingList);
    }
    return "readingList";
  }

  /**
   * 添加阅读列表
   *
   * @param reader
   * @param book
   * @return
   */
  @RequestMapping(value = "/{reader}", method = RequestMethod.POST)
  public String addToReadingList(@PathVariable("reader") String reader, Book book) {
    book.setReader(reader);
    readingListRepository.save(book);
    return "redirect:/{reader}";
  }

}
