package com.jakewharton.javaversions.java11;

interface LambdaParameterTypeInference<T> {
  String render(T value);

  static void main(String[] args) {
    LambdaParameterTypeInference<Integer> a = (var value) -> value.toString();
    System.out.println(a.render(1));
  }
}
