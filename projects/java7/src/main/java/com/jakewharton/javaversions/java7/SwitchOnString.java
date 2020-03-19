package com.jakewharton.javaversions.java7;

final class SwitchOnString {
  public static void main(String[] args) {
    switch (args[0]) {
      case "hello":
        System.out.println("Hello!");
        break;
      case "hi":
        System.out.println("Hi!");
        break;
      default:
        System.out.println("Unknown command");
        break;
    }
  }
}
