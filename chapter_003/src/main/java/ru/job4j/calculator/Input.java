package ru.job4j.calculator;

public interface Input {
  public String getOperationName();
  public double execute(Calculate calc, double a);
}
