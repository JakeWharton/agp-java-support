package com.jakewharton.javaversions.java8;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE_USE)
@interface TypeAnnotation {
  class Test<T extends @TypeAnnotation Object> {
  }
}
