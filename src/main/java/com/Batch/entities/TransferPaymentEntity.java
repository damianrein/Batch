package com.Batch.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="transfer_payment_history")
public class TransferPaymentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name="transaction_id", nullable=false)
	private String transactionId;
	@Column(name="avariable_balance", nullable=false)
	private BigDecimal avariableBalance;
	@Column(name="amount_paid", nullable=false)
	private BigDecimal amountPaid;
	@Column(name="enabled", nullable=false)
	private boolean enabled;
	@Column(name="is_processed", nullable=false)
	private boolean isProcessed;
	@Column(name="error", nullable=true)
	private String error;
	
	public TransferPaymentEntity() {}
	
	public TransferPaymentEntity(String transactionId, BigDecimal avariableBalance, BigDecimal amountPaid,
			boolean isEnabled, boolean isProcessed, String error) {
		this.transactionId = transactionId;
		this.avariableBalance = avariableBalance;
		this.amountPaid = amountPaid;
		this.enabled = isEnabled;
		this.isProcessed = isProcessed;
		this.error = error;
	}
	public BigDecimal getAvariableBalance() {
		return avariableBalance;
	}
	public void setAvariableBalance(BigDecimal avariableBalance) {
		this.avariableBalance = avariableBalance;
	}
	public BigDecimal getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(BigDecimal amountPaid) {
		this.amountPaid = amountPaid;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean isEnabled) {
		this.enabled = isEnabled;
	}
	public boolean isProcessed() {
		return isProcessed;
	}
	public void setProcessed(boolean isProcessed) {
		this.isProcessed = isProcessed;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getTransactionId() {
		return transactionId;
	}
}
