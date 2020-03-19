package com.jakewharton.javaversions.java8;

final class MethodReference {
  private static void run(Runnable runnable) {
    runnable.run();
  }

  private static void sayHello() {
    System.out.println("Hello");
  }

  public static void main(String[] args) {
    run(MethodReference::sayHello);
  }
}
