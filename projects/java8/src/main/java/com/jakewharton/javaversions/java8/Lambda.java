package com.jakewharton.javaversions.java8;

final class Lambda {
  private static void run(Runnable runnable) {
    runnable.run();
  }

  public static void main(String[] args) {
    run(() -> System.out.println("Hello"));
  }
}
