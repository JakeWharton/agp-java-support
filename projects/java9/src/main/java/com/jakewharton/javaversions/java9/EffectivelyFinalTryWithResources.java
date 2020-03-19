package com.jakewharton.javaversions.java9;

import java.io.Closeable;
import java.io.IOException;

final class EffectivelyFinalTryWithResources {
  public static void main(String[] args) throws IOException {
    Closeable c = () -> {};
    try (c) {
      System.out.println(c);
    }
  }
}
