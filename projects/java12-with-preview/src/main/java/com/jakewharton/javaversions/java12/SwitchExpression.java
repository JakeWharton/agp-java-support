package com.jakewharton.javaversions.java12;

final class SwitchExpression {
  public static void main(String[] args) {
    String countArrow = switch (args.length) {
      case 0 -> "zero";
      case 1 -> {
        break "one";
      }
      default -> Integer.toString(args.length);
    };
    System.out.println(countArrow);

    String countColon = switch (args.length) {
      case 0: break "zero";
      case 1: {
        break "one";
      }
      default: break Integer.toString(args.length);
    };
    System.out.println(countColon);
  }
}
