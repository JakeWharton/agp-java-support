package com.jakewharton.javaversions.java8;

public interface InterfaceDefaultMethod {
  default void sayHello() {
    System.out.println("Hello");
  }
}
