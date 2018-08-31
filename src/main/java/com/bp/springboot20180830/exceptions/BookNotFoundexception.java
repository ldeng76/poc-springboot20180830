package com.bp.springboot20180830.exceptions;

/**
 * Created by dzy on 2018/8/30
 */
public class BookNotFoundexception extends RuntimeException{
  public BookNotFoundexception(String message, Throwable cause) {
    super(message, cause);
  }
}
