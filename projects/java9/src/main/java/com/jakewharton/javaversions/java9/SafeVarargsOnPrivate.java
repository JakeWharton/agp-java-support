package com.jakewharton.javaversions.java9;

import java.util.Arrays;
import java.util.List;

final class SafeVarargsOnPrivate {
  @SafeVarargs private static <T> List<T> myList(T... args) {
    return Arrays.asList(args);
  }
}
