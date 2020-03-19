package com.jakewharton.javaversions.java7;

import java.util.Arrays;
import java.util.List;

final class SafeVarargsOnMethod {
  @SafeVarargs
  static <T> List<T> myList(T... items) {
    return Arrays.asList(items);
  }
}
