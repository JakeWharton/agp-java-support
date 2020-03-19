package com.jakewharton.javaversions.java13;

final class SwitchExpression {
  public static void main(String[] args) {
    String countArrow = switch (args.length) {
      case 0 -> "zero";
      case 1 -> {
        yield "one";
      }
      default -> Integer.toString(args.length);
    };
    System.out.println(countArrow);

    String countColon = switch (args.length) {
      case 0: yield "zero";
      case 1: {
        yield "one";
      }
      default: yield Integer.toString(args.length);
    };
    System.out.println(countColon);
  }
}
