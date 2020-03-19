package com.jakewharton.javaversions.java9;

interface AnonymousDiamond<T> {
  T get();

  public static void main(String[] args) {
    AnonymousDiamond<String> stringSupplier = new AnonymousDiamond<>() {
      int counter = 0;
      @Override public String get() {
        return "Hello" + (counter++);
      }
    };

    System.out.println(stringSupplier.get());
    System.out.println(stringSupplier.get());
    System.out.println(stringSupplier.get());
  }
}
