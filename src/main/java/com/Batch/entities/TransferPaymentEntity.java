package com.Batch.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="transfer_payment_history")
public class TransferPaymentEntity {

	@Id
	@Column(name="transaction_id", nullable=false)
	private String transactionId;
	@Column(name="avariable_balance", nullable=false)
	private BigDecimal avariableBalance;
	@Column(name="amount_paid", nullable=false)
	private BigDecimal amountPaid;
	@Column(name="enabled", nullable=false)
	private boolean isEnabled;
	@Column(name="is_processed", nullable=false)
	private boolean isProcessed;
	@Column(name="error", nullable=true)
	private String error;
}
