package org.example.cashbackservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CalculateRequestDto {
  @Min(0)
  @Max(100_000_000_000L)
  private long amount;
}
