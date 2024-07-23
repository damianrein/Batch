package com.Batch.dtos;

import java.math.BigDecimal;

public record TransferPaymentDto(BigDecimal avariableBalance, BigDecimal amountPaid, boolean enabled) {

}
