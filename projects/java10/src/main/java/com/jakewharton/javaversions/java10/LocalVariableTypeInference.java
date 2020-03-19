package com.jakewharton.javaversions.java10;

import java.util.ArrayList;

class LocalVariableTypeInference {
  public static void main(String[] args) {
    var list = new ArrayList<String>();
    list.add("Hello");
    System.out.println(list);
  }
}
