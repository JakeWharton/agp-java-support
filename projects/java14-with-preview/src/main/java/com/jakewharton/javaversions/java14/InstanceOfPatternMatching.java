package com.jakewharton.javaversions.java14;

final class InstanceOfPatternMatching {
  public static void main(String[] args) {
    Object o = "hey";
    if (o instanceof String s) {
      System.out.println("String: " + s);
    } else {
      System.out.println("Object: " + o);
    }
  }
}
