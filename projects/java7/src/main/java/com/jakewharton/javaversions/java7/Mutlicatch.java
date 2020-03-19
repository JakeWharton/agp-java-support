package com.jakewharton.javaversions.java7;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

final class Mutlicatch {
  public static void main(String[] args) {
    try {
      if (args.length > 1) {
        throw new IOException();
      } else {
        throw new TimeoutException();
      }
    } catch (IOException | TimeoutException e) {
      e.printStackTrace(System.out);
    }
  }
}
