package org.example.cashbackservice.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashbackServiceTest {
  @Test
  void shouldCalculate() {
    final long expected = 3;
    final long amount = 100;
    final CashbackService service = new CashbackService();

    final long actual = service.calculate(amount);

    assertEquals(expected, actual);
  }
}