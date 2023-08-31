package org.example.cashbackservice.controller;

import lombok.RequiredArgsConstructor;
import org.example.cashbackservice.dto.CalculateRequestDto;
import org.example.cashbackservice.dto.CalculateResponseDto;
import org.example.cashbackservice.service.CashbackService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Validated
@RestController
@RequestMapping("/api/cashback")
@RequiredArgsConstructor
public class CashbackController {
  private final CashbackService service;

  @PostMapping
  public CalculateResponseDto calculate(
      @Valid
      @RequestBody
      final CalculateRequestDto requestDto
  ) {
    final long result = this.service.calculate(requestDto.getAmount());
    final CalculateResponseDto responseDto = new CalculateResponseDto(result);
    return responseDto;
  }
}
