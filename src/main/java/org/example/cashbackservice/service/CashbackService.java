package org.example.cashbackservice.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Optional;

@Service
@Validated
public class CashbackService {
  private static final long PERCENT = Optional.ofNullable(System.getenv("APP_PERCENT")).map(Long::parseLong).orElse(3L);
  private static final long LIMIT = Optional.ofNullable(System.getenv("APP_LIMIT")).map(Long::parseLong).orElse(300L);

  public long calculate(
      @Min(0)
      @Max(100_000_000_000L)
      final long amount
  ) {
    final long cashback = amount * PERCENT / 100L;
    return Math.min(cashback, LIMIT);
  }
}
