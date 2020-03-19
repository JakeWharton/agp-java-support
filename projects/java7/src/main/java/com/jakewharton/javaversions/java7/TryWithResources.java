package com.jakewharton.javaversions.java7;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

final class TryWithResources {
  public static void main(String[] args) throws IOException {
    try (OutputStream os = new BufferedOutputStream(System.out)) {
      os.write(0);
    }
  }
}
