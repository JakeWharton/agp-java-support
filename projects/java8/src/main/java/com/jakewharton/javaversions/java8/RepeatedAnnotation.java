package com.jakewharton.javaversions.java8;

import java.lang.annotation.Repeatable;

@interface RepeatedAnnotation {
  Say[] value();

  @Repeatable(RepeatedAnnotation.class)
  @interface Say {
    String value();
  }

  @Say("Hello")
  @Say("Hi")
  class Test {}
}
